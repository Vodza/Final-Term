package Server.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import Server.RunServer;
import Server.DB.Layers.BUS.GameMatchBUS;
import Server.DB.Layers.DTO.GameMatch;
import Server.game.GameLogic;
import Server.game.caro.Caro;
import Server.game.caro.History;
import Shared.constant.StreamData;

public class Room {

    String id;
    Caro gamelogic;
    Client client1 = null, client2 = null;
    ArrayList<Client> clients = new ArrayList<>();
    boolean gameStarted = false;

    public LocalDateTime startedTime;

    public Room(String id) {
        // room id
        this.id = id;

        // create game logic
        gamelogic = new Caro();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    @SuppressWarnings("rawtypes")
    public void startGame() {
        startedTime = LocalDateTime.now();
        gameStarted = true;
        gamelogic.getTurnTimer()
                .setTimerCallBack(
                        // end turn callback
                        (Callable) () -> {
                            // TURN_TIMER_END;<winner-email>
                            broadcast(
                                    StreamData.Type.GAME_EVENT + ";"
                                            + StreamData.Type.TURN_TIMER_END.name() + ";"
                                            + gamelogic.getLastMoveEmail());
                            return null;
                        },
                        // tick turn callback
                        (Callable) () -> {
                            broadcast(
                                    StreamData.Type.GAME_EVENT + ";"
                                            + StreamData.Type.TURN_TICK.name() + ";"
                                            + gamelogic.getTurnTimer().getCurrentTick());
                            return null;
                        },
                        // tick interval
                        Caro.TURN_TIME_LIMIT / 10);

        gamelogic.getMatchTimer()
                .setTimerCallBack(
                        // end match callback
                        (Callable) () -> {

                            // tinh diem hoa
                            new GameMatchBUS().add(new GameMatch(
                                    client1.getLoginPlayer().getId(),
                                    client1.getLoginPlayer().getId(),
                                    -1,
                                    gamelogic.getMatchTimer().getCurrentTick(),
                                    gamelogic.getHistory().size(),
                                    startedTime));

                            broadcast(
                                    StreamData.Type.GAME_EVENT + ";"
                                            + StreamData.Type.MATCH_TIMER_END.name());
                            return null;
                        },
                        // tick match callback
                        (Callable) () -> {
                            broadcast(
                                    StreamData.Type.GAME_EVENT + ";"
                                            + StreamData.Type.MATCH_TICK.name() + ";"
                                            + gamelogic.getMatchTimer().getCurrentTick());
                            return null;
                        },
                        // tick interval
                        Caro.MATCH_TIME_LIMIT / 10);
    }

    // add/remove client
    public boolean addClient(Client c, boolean isWatcher) {
        if (!clients.contains(c)) {
            clients.add(c);

            if (!isWatcher) {
                if (client1 == null) {
                    client1 = c;
                } else if (client2 == null) {
                    client2 = c;
                }
            }

            return true;
        }
        return false;
    }

    public boolean removeClient(Client c) {
        if (clients.contains(c)) {
            clients.remove(c);
            return true;
        }
        return false;
    }

    // broadcast messages
    public void broadcast(String msg) {
        clients.forEach((c) -> {
            c.sendData(msg);
        });
    }

    public void close(String reason) {
        // notify all client in room
        broadcast(StreamData.Type.CLOSE_ROOM.name() + ";" + reason);

        // remove reference
        clients.forEach((client) -> {
            client.setJoinedRoom(null);
        });

        // remove all clients
        clients.clear();

        // remove room
        RunServer.roomManager.remove(this);
    }

    // get room data
    public String getFullData() {
        String data = "";

        // player data
        data += getClient12InGameData() + ";";
        data += getListClientData() + ";";
        // timer
        data += getTimerData() + ";";
        // board
        data += getBoardData();

        return data;
    }

    public String getTimerData() {
        String data = "";

        data += Caro.MATCH_TIME_LIMIT + ";" + gamelogic.getMatchTimer().getCurrentTick() + ";";
        data += Caro.TURN_TIME_LIMIT + ";" + gamelogic.getTurnTimer().getCurrentTick();

        return data;
    }

    public String getBoardData() {
        ArrayList<History> history = gamelogic.getHistory();

        String data = history.size() + ";";
        for (History his : history) {
            data += his.getRow() + ";" + his.getColumn() + ";" + his.getPlayerEmail() + ";";
        }

        return data.substring(0, data.length() - 1); // bỏ dấu ; ở cuối
    }

    public String getClient12InGameData() {
        String data = "";

        data += (client1 == null ? Client.getEmptyInGameData() : client1.getInGameData() + ";");
        data += (client2 == null ? Client.getEmptyInGameData() : client2.getInGameData());

        return data;
    }

    public String getListClientData() {
        // kết quả trả về có dạng playerCount;player1_data;player2_data;...;playerN_data

        String data = clients.size() + ";";

        for (Client c : clients) {
            data += c.getInGameData() + ";";
        }

        return data.substring(0, data.length() - 1); // bỏ dấu ; ở cuối
    }

    // gets sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameLogic getGamelogic() {
        return gamelogic;
    }

    public void setGamelogic(Caro gamelogic) {
        this.gamelogic = gamelogic;
    }

    public Client getClient1() {
        return client1;
    }

    public void setClient1(Client client1) {
        this.client1 = client1;
    }

    public Client getClient2() {
        return client2;
    }

    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

}
