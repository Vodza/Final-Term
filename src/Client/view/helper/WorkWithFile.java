package Client.view.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkWithFile {

    public static boolean write(String filepath, String s) {
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(filepath, false))) {
            os.writeUTF(s);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static String read(String filepath) {
        try (DataInputStream os = new DataInputStream(new FileInputStream(filepath))) {
            String result = os.readUTF();
            return result;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkWithFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
