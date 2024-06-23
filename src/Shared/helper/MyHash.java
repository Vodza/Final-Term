package Shared.helper;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class MyHash {

    public static String hash_WTF(String str) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(str.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = factory.generateSecret(spec).getEncoded();

            return new String(hash);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(MyHash.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    // https://stackoverflow.com/a/5531479
    public static String hash_sha_256(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

            return new String(hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MyHash.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    // https://www.geeksforgeeks.org/md5-hash-in-java/
    // hàm này dùng md5
    public static String hash(String str) {
        try {
            // Phương thức getInstance tĩnh được gọi bằng hàm băm MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(str.getBytes());

            // Chuyển đổi mảng byte thành biểu diễn signnum
            BigInteger no = new BigInteger(1, messageDigest);

            // Chuyển đổi thông báo tóm tắt thành giá trị hex
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;

        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }

        return "";
    }

}
