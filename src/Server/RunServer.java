package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import Server.controller.Admin;
import Server.controller.Client;
import Server.controller.ClientManager;
import Server.controller.RoomManager;
import Shared.security.RSA;

public class RunServer {

    public static volatile ClientManager clientManager;
    public static volatile RoomManager roomManager;
    public static volatile RSA serverSide;
    public static boolean isShutDown = false;
    public static ServerSocket ss;

    public RunServer() {

        try {
            int port = 5056;

            ss = new ServerSocket(port);
            System.out.println("Created Server at port " + port + ".");

            // init rsa key
            serverSide = new RSA()
                    .preparePrivateKey("src/Server/rsa_keypair/privateKey");

            // init managers
            clientManager = new ClientManager();
            roomManager = new RoomManager();

            // create threadpool
            @SuppressWarnings("resource")
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    10, // corePoolSize
                    100, // maximumPoolSize
                    10, // thread timeout
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(8) // queueCapacity
            );

            // admin
            executor.execute(new Admin());

            // server main loop - listen to client's connection
            while (!isShutDown) {
                try {
                    // socket object to receive incoming client requests
                    Socket s = ss.accept();
                    // System.out.println("+ New Client connected: " + s);

                    // create new client runnable object
                    Client c = new Client(s);
                    clientManager.add(c);

                    // execute client runnable
                    executor.execute(c);

                } catch (IOException ex) {
                    // Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    isShutDown = true;
                }
            }

            System.out.println("shutingdown executor...");
            executor.shutdownNow();

        } catch (IOException ex) {
            Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new RunServer();
    }
}
