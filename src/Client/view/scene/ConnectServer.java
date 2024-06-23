package Client.view.scene;

import javax.swing.JOptionPane;

import Client.RunClient;

public class ConnectServer extends javax.swing.JFrame {

    /**
     * Creates new form ChooseServer
     */
    public ConnectServer() {
        initComponents();
        this.setLocationRelativeTo(null);

        // default is hidden
        pgbLoading.setVisible(false);
    }

    public void setLoading(boolean isLoading, String btnText) {
        pgbLoading.setVisible(isLoading);
        btnConnect.setEnabled(!isLoading);
        btnConnect.setText(isLoading ? btnText : "Kết nối");
    }

    private void initComponents() {

        txIP = new javax.swing.JTextField();
        txPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pgbLoading = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kết nối");

        txIP.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txIP.setText("127.0.0.1");

        txPort.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txPort.setText("5056");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("KẾT NỐI SERVER");

        btnConnect.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnConnect.setText("Kết nối");
        btnConnect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel3.setText("IP");

        jLabel4.setText("Port");

        pgbLoading.setIndeterminate(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER,
                                                layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pgbLoading, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                292, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txIP,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                207,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(92, 92, 92)
                                                                                .addComponent(jLabel3)))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txPort)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel4)
                                                                                        .addGap(29, 29, 29)))))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txIP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txPort, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24,
                                        Short.MAX_VALUE)
                                .addComponent(pgbLoading, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConnectActionPerformed
        String ip;
        int port;

        // validate input
        try {
            ip = txIP.getText();
            port = Integer.parseInt(txPort.getText());

            if (port < 0 || port > 65535) {
                JOptionPane.showMessageDialog(this, "Port phải từ 0 - 65535", "Sai port", JOptionPane.ERROR_MESSAGE);
                txPort.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Port phải là số nguyên", "Sai port", JOptionPane.ERROR_MESSAGE);
            txPort.requestFocus();
            return;
        }

        // connect to server
        connect(ip, port);
    }

    private void connect(String ip, int port) {
        // show loading
        setLoading(true, "Đang kết nối..");

        // connect to server
        new Thread(() -> {
            // call controller
            String result = RunClient.socketHandler.connect(ip, port);

            // check result
            if (result.equals("success")) {
                onSuccess();
            } else {
                String failedMsg = result.split(";")[1];
                onFailed(failedMsg);
            }
        }).start();
    }

    private void onSuccess() {
        // Kết nối thành công nhưng vẫn chờ server gửi thông báo đã nhận AES key
        // Scene sẽ được chuyển qua LoginScene khi client nhận được phản hồi từ server
        // => code chuyển scene được đưa vào socket handler, lúc listen nhận được AESKEY
        // từ server
        // this.dispose();
        // RunClient.openScene(RunClient.SceneName.LOGIN);
        // khi kết nối thành công sẽ đợi tạo kết nối bảo mật (gửi nhận AES key)
        setLoading(true, "Đang bảo mật..");
    }

    private void onFailed(String failedMsg) {
        setLoading(false, null);
        JOptionPane.showMessageDialog(this, failedMsg, "Lỗi kết nối", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnectServer.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectServer.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectServer.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectServer.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar pgbLoading;
    private javax.swing.JTextField txIP;
    private javax.swing.JTextField txPort;
    // End of variables declaration//GEN-END:variables
}
