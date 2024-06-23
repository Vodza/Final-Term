package Client.view.scene;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Client.RunClient;
import Client.view.helper.Validation;
import Shared.constant.Avatar;

public class Signup extends javax.swing.JFrame {

        /**
         * Creates new form SignupF
         */
        public Signup() {
                initComponents();
                this.setLocationRelativeTo(null);

                // avatar combobox
                cbAvatar.setMaximumRowCount(5);
                for (String s : Avatar.LIST) {
                        cbAvatar.addItem(new ImageIcon(Avatar.PATH + s));
                }

                // default is hidden
                pgbLoading.setVisible(false);
        }

        private String getAvatar() {
                String fullPath = cbAvatar.getSelectedItem().toString();
                String[] splitted = fullPath.split("/");

                return splitted[splitted.length - 1];
        }

        public void setLoading(boolean isLoading) {
                pgbLoading.setVisible(isLoading);
                btnSignup.setEnabled(!isLoading);
                btnLogin.setEnabled(!isLoading);
                btnSignup.setText(isLoading ? "Đang xử lý.." : "Đăng ký");
        }

        private void initComponents() {

                lbHeaderText = new javax.swing.JLabel();
                plInput = new javax.swing.JPanel();
                lbEmail = new javax.swing.JLabel();
                txEmail = new javax.swing.JTextField();
                lbUserName = new javax.swing.JLabel();
                txName = new javax.swing.JTextField();
                lbPassword = new javax.swing.JLabel();
                txPassword = new javax.swing.JPasswordField();
                txRetypePassword = new javax.swing.JPasswordField();
                lbPassword1 = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                lbBirthday = new javax.swing.JLabel();
                txYearOfBirth = new javax.swing.JTextField();
                lbGender = new javax.swing.JLabel();
                cbGender = new javax.swing.JComboBox<>();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                btnSignup = new javax.swing.JButton();
                cbAvatar = new javax.swing.JComboBox<>();
                btnLogin = new javax.swing.JButton();
                pgbLoading = new javax.swing.JProgressBar();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Đăng ký");
                setResizable(false);

                lbHeaderText.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
                lbHeaderText.setText("THAM GIA");

                lbEmail.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_email_48px.png"))); // NOI18N

                txEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                txEmail.setToolTipText("Email");

                lbUserName.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_name_48px_1.png"))); // NOI18N

                txName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                txName.setToolTipText("Tên");

                lbPassword.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_password_48px.png"))); // NOI18N

                txPassword.setToolTipText("Mật khẩu");

                txRetypePassword.setToolTipText("Mật khẩu");

                lbPassword1.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/client/view/asset/icons8_password_reset_48px.png"))); // NOI18N

                jLabel1.setText("Email");

                jLabel2.setText("Mật khẩu");

                lbBirthday.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                lbBirthday.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_birthday_cake_48px_2.png"))); // NOI18N

                txYearOfBirth.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                txYearOfBirth.setToolTipText("Năm sinh");

                lbGender.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                lbGender.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_gender_48px.png"))); // NOI18N

                cbGender.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Ẩn" }));
                cbGender.setToolTipText("Giới tính");
                cbGender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jLabel3.setText("Tên");

                jLabel4.setText("Nhập lại mật khẩu");

                jLabel5.setText("Năm sinh");

                jLabel6.setText("Giới tính");

                javax.swing.GroupLayout plInputLayout = new javax.swing.GroupLayout(plInput);
                plInput.setLayout(plInputLayout);
                plInputLayout.setHorizontalGroup(
                                plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plInputLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(plInputLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(lbBirthday)
                                                                                                .addGroup(plInputLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jLabel5))
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                .addComponent(txYearOfBirth,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                250,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(plInputLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(plInputLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbEmail)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(plInputLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel1)
                                                                                                                                                .addComponent(txEmail,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                250,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbUserName)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(plInputLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel3)
                                                                                                                                                .addComponent(txName))))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(plInputLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbPassword)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(plInputLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel2)
                                                                                                                                                .addComponent(txPassword,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                250,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbPassword1)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(plInputLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel4)
                                                                                                                                                .addComponent(txRetypePassword,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                250,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jLabel6)))
                                                                                                                .addGroup(plInputLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbGender)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(cbGender,
                                                                                                                                                0,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)))))
                                                                .addContainerGap()));
                plInputLayout.setVerticalGroup(
                                plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plInputLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(plInputLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(lbEmail,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(txEmail,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                48,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(txPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lbPassword))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel4))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(plInputLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(lbUserName,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(txName,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                48,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(txRetypePassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lbPassword1))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jLabel6))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(plInputLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(txYearOfBirth)
                                                                                                .addComponent(lbBirthday))
                                                                                .addComponent(lbGender)
                                                                                .addComponent(cbGender,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                btnSignup.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
                btnSignup.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_slide_up_32px.png"))); // NOI18N
                btnSignup.setText("ĐĂNG KÝ");
                btnSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnSignup.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btnSignupMouseClicked(evt);
                        }
                });

                cbAvatar.setToolTipText("Ảnh đại diện");
                cbAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                btnLogin.setText("Đăng nhập?");
                btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btnLoginMouseClicked(evt);
                        }
                });

                pgbLoading.setIndeterminate(true);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(cbAvatar,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                170,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lbHeaderText)
                                                                                .addComponent(btnSignup,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                322,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnLogin)
                                                                                .addComponent(plInput,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(pgbLoading,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                315,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(lbHeaderText)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(cbAvatar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                95,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(plInput,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(pgbLoading,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSignup,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                63,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnLogin)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnSignupMouseClicked(java.awt.event.MouseEvent evt) {
                try {
                        // get data from form
                        String email = txEmail.getText();
                        String password = new String(txPassword.getPassword());
                        String rePass = new String(txRetypePassword.getPassword());
                        String name = txName.getText();
                        String gender = cbGender.getSelectedItem().toString();
                        int yearOfBirth = Integer.parseInt(txYearOfBirth.getText());
                        String avatar = getAvatar();

                        // validate
                        if (!Validation.checkPassword(password)) {
                                JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6-30 ký tự", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                txPassword.requestFocus();
                                return;
                        }
                        if (!rePass.equals(password)) {
                                JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu chưa khớp", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                txRetypePassword.requestFocus();
                                return;
                        }
                        if (!Validation.checkEmail(email)) {
                                JOptionPane.showMessageDialog(this, "Email không hợp lệ", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                txEmail.requestFocus();
                                return;
                        }
                        if (!Validation.checkName(name)) {
                                JOptionPane.showMessageDialog(this, "Tên là tiếng việt không dấu và"
                                                + " không quá 15 ký tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                txName.requestFocus();
                                return;
                        }
                        if (!Validation.checkYearOfBirth(yearOfBirth)) {
                                JOptionPane.showMessageDialog(this,
                                                "Chưa sinh ra hoặc quá 100 tuổi vui lòng đừng chơi!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                txYearOfBirth.requestFocus();
                                return;
                        }

                        // call signup from socket handler
                        setLoading(true);
                        RunClient.socketHandler.signup(email, password, name, gender, yearOfBirth, avatar);

                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Năm sinh phải là số nguyên", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        txYearOfBirth.requestFocus();
                }
        }

        private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {
                this.dispose();
                RunClient.openScene(RunClient.SceneName.LOGIN);
        }

        public static void main(String args[]) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Signup().setVisible(true);
                        }
                });
        }

        private javax.swing.JButton btnLogin;
        private javax.swing.JButton btnSignup;
        private javax.swing.JComboBox<ImageIcon> cbAvatar;
        private javax.swing.JComboBox<String> cbGender;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel lbBirthday;
        private javax.swing.JLabel lbEmail;
        private javax.swing.JLabel lbGender;
        private javax.swing.JLabel lbHeaderText;
        private javax.swing.JLabel lbPassword;
        private javax.swing.JLabel lbPassword1;
        private javax.swing.JLabel lbUserName;
        private javax.swing.JProgressBar pgbLoading;
        private javax.swing.JPanel plInput;
        private javax.swing.JTextField txEmail;
        private javax.swing.JTextField txName;
        private javax.swing.JPasswordField txPassword;
        private javax.swing.JPasswordField txRetypePassword;
        private javax.swing.JTextField txYearOfBirth;

}
