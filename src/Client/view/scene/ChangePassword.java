package Client.view.scene;

import javax.swing.JOptionPane;

import Client.RunClient;

public class ChangePassword extends javax.swing.JFrame {

        /**
         * Creates new form ChangePassword
         */
        public ChangePassword() {
                initComponents();
                this.setLocationRelativeTo(RunClient.profileScene);

                pgbLoading.setVisible(false);
        }

        public void setLoading(boolean isLoading) {
                pgbLoading.setVisible(isLoading);
                btnCancel.setEnabled(!isLoading);
                btnSave.setEnabled(!isLoading);

                btnSave.setText(isLoading ? "Đang xử lý.." : "Lưu");
        }

        private void initComponents() {

                jPanel8 = new javax.swing.JPanel();
                lbBirthday1 = new javax.swing.JLabel();
                txOldPassword = new javax.swing.JPasswordField();
                txNewPassword = new javax.swing.JPasswordField();
                lbBirthday2 = new javax.swing.JLabel();
                txRepeatPassword = new javax.swing.JPasswordField();
                lbBirthday3 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                pgbLoading = new javax.swing.JProgressBar();
                btnCancel = new javax.swing.JButton();
                btnSave = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Đổi mật khẩu");
                setLocationByPlatform(true);
                setResizable(false);

                lbBirthday1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                lbBirthday1.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_forgot_password_48px.png"))); // NOI18N

                lbBirthday2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                lbBirthday2.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_password_48px.png"))); // NOI18N

                lbBirthday3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
                lbBirthday3.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_forgot_password_48px.png"))); // NOI18N

                jLabel9.setText("Mật khẩu cũ");

                jLabel10.setText("Mật khẩu mới");

                jLabel11.setText("Nhập lại mật khẩu mới");

                pgbLoading.setIndeterminate(true);

                btnCancel.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_cancel_24px.png"))); // NOI18N
                btnCancel.setText("Hủy");
                btnCancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelActionPerformed(evt);
                        }
                });

                btnSave.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_ok_24px.png"))); // NOI18N
                btnSave.setText("Lưu");
                btnSave.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSaveActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel8Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(pgbLoading,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel8Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel8Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbBirthday1)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel9)
                                                                                                                                                .addComponent(txOldPassword,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                199,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbBirthday2)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel10)
                                                                                                                                                .addComponent(txNewPassword,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                199,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(lbBirthday3)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(jPanel8Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel11)
                                                                                                                                                .addComponent(txRepeatPassword,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                199,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap())
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnCancel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSave)));
                jPanel8Layout.setVerticalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(lbBirthday1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(txOldPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel10)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(lbBirthday2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(txNewPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel11)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(lbBirthday3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(txRepeatPassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgbLoading,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnSave)
                                                                                .addComponent(btnCancel))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
                // prepare data
                String oldPass = new String(txOldPassword.getPassword());
                String newPass = new String(txNewPassword.getPassword());
                String rePass = new String(txRepeatPassword.getPassword());

                // check repass
                if (!newPass.equals(rePass)) {
                        JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        txRepeatPassword.requestFocus();
                        return;
                }

                // turn on loading
                setLoading(true);

                // call change pass from socket handler
                RunClient.socketHandler.changePassword(oldPass, newPass);
        }// GEN-LAST:event_btnSaveActionPerformed

        private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
                this.dispose();
        }// GEN-LAST:event_btnCancelActionPerformed

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
                        java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new ChangePassword().setVisible(true);
                        }
                });
        }

        private javax.swing.JButton btnCancel;
        private javax.swing.JButton btnSave;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JLabel lbBirthday1;
        private javax.swing.JLabel lbBirthday2;
        private javax.swing.JLabel lbBirthday3;
        private javax.swing.JProgressBar pgbLoading;
        private javax.swing.JPasswordField txNewPassword;
        private javax.swing.JPasswordField txOldPassword;
        private javax.swing.JPasswordField txRepeatPassword;

}
