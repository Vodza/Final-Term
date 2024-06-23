package Client.view.helper;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Validation {

    public static boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean checkPassword(String pass) {
        return pass.length() >= 6 && pass.length() <= 30;
    }

    // Tên không hợp lệ nếu có khoảng trống
    public static boolean checkName(String name) {
        if (!removeAccent(name).equalsIgnoreCase(name) || name.contains(" ")) {
            return false;
        }
        return name.length() > 0 && name.length() <= 15;
    }

    // http://sinhviencntt.blogspot.com/2015/01/code-java-chuyen-oi-tieng-viet-co-dau.html
    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static boolean checkYearOfBirth(int year) {
        LocalDate date = LocalDate.now();
        return year <= date.getYear() && year > date.minusYears(100).getYear();
    }

    public static boolean checkInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Listener for NumberInput fields.
    // Cần gọi các thay đổi đối với tài liệu từ Event Dispatcher Thread,
    // nếu không thì ngoại lệ 'Attempt to mutate notification' được ném ra
    // https://stackoverflow.com/questions/15206586/getting-attempt-to-mutate-notification-exception
    public static void checkNumberInputChanged(JTextField numberFormatedField) {
        Runnable doAssist = new Runnable() {
            String temp = numberFormatedField.getText();// temp = 1234a

            @Override
            public void run() {
                // kiểm tra xem đầu vào có phải là số nguyên không
                if (!checkInt(temp)) { // temp = 1234a
                    // vòng lặp để xóa char cuối cùng nếu không phải là Số nguyên cho đến khi temp
                    // là Số nguyên
                    while (!checkInt(temp)) { // temp = 1234a
                        temp = temp.substring(0, temp.length() - 1);// temp = 1234
                    }
                    // Đặt temp làm văn bản cho textField
                    numberFormatedField.setText(temp);
                }

            }
        };
        SwingUtilities.invokeLater(doAssist);
    }
}
