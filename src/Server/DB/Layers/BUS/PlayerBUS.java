package Server.DB.Layers.BUS;

import java.util.ArrayList;

import Server.DB.Layers.DAL.PlayerDAL;
import Server.DB.Layers.DTO.Player;
import Shared.constant.Code;

public class PlayerBUS {

    ArrayList<Player> listPlayer = new ArrayList<>();
    PlayerDAL playerDAL = new PlayerDAL();

    public PlayerBUS() {
        readDB();
    }

    @SuppressWarnings("unchecked")
    public void readDB() {
        listPlayer = playerDAL.readDB();
    }

    public boolean add(Player p) {
        boolean status = playerDAL.add(p);

        if (status == true) {
            listPlayer.add(p);
        }

        return status;
    }

    public boolean delete(int id) {
        boolean status = playerDAL.delete(id);

        if (status == true) {
            for (int i = (listPlayer.size() - 1); i >= 0; i--) {
                if (listPlayer.get(i).getId() == id) {
                    listPlayer.remove(i);
                }
            }
        }

        return status;
    }

    public boolean update(Player p) {
        boolean status = playerDAL.update(p);

        if (status == true) {
            listPlayer.forEach((pl) -> {
                pl = new Player(p);
            });
        }

        return status;
    }

    public Player getById(int id) {
        for (Player p : listPlayer) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Player getByEmail(String email) {
        for (Player p : listPlayer) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Player> getList() {
        return listPlayer;
    }

    public String checkLogin(String email, String password) {
        // check email
        Player p = getByEmail(email);
        if (p == null) {
            return "failed;" + Code.ACCOUNT_NOT_FOUND;
        }

        // check password
        if (!p.getPassword().equals(password)) {
            return "failed;" + Code.WRONG_PASSWORD;
        }

        // check blocked
        if (p.isBlocked()) {
            return "failed;" + Code.ACCOUNT_BLOCKED;
        }

        return "success;" + email;
    }

    public String changePassword(String email, String oldPassword, String newPassword) {
        // check email
        Player p = getByEmail(email);
        if (p == null) {
            return "failed;" + Code.ACCOUNT_NOT_FOUND;
        }

        // check password
        if (!p.getPassword().equals(oldPassword)) {
            return "failed;" + Code.WRONG_PASSWORD;
        }

        // đặt pass mới
        p.setPassword(newPassword);
        boolean status = update(p);
        if (!status) {
            // lỗi không xác định
            return "failed;Lỗi khi đổi mật khẩu";
        }

        return "success";
    }

    public String signup(String email, String password, String avatar, String name, String gender, int yearOfBirth) {

        // check email
        Player p = getByEmail(email);
        if (p != null) {
            return "failed;" + Code.EMAIL_EXISTED;
        }

        // thêm vào db
        boolean status = add(new Player(email, password, avatar, name, gender, yearOfBirth));
        if (!status) {
            // lỗi ko xác định
            return "failed;Lỗi khi đăng ký";
        }

        return "success";
    }

    public String editProfile(String email, String newEmail, String name, String avatar, int yearOfBirth,
            String gender) {
        // check trung email
        if (!newEmail.equals(email) && getByEmail(newEmail) != null) {
            return "failed;" + Code.EMAIL_EXISTED;
        }

        // check email
        Player p = getByEmail(email);
        if (p == null) {
            return "failed;" + Code.ACCOUNT_NOT_FOUND;
        }

        // set data
        p.setEmail(newEmail);
        p.setName(name);
        p.setAvatar(avatar);
        p.setYearOfBirth(yearOfBirth);
        p.setGender(gender);

        // update
        boolean status = update(p);

        if (!status) {
            return "failed;Lỗi khi cập nhật thông tin cá nhân";
        }

        return "success;" + newEmail;
    }
}
