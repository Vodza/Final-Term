package Client.view.scene;

import java.util.Vector;
import java.util.concurrent.Callable;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Client.RunClient;
import Client.view.helper.LookAndFeel;
import Shared.helper.CountDownTimer;

public class MainMenu extends javax.swing.JFrame {

        public enum State {
                DEFAULT,
                FINDING_MATCH,
                WAITING_ACCEPT,
                WAITING_COMPETITOR_ACCEPT
        };

        CountDownTimer acceptPairMatchTimer;
        CountDownTimer waitingPairTimer;
        final int acceptWaitingTime = 15;

        boolean pairAcceptChoosed = false;

        /**
         * Creates new form MainMenuF
         */
        public MainMenu() {
                initComponents();
                this.setLocationRelativeTo(null);
                this.setTitle("Caro Game - " + RunClient.socketHandler.getLoginEmail());

                // default to hidden
                setDisplayState(State.DEFAULT);
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public void setListRoom(Vector vdata, Vector vheader) {
                tbListRoom.setModel(new DefaultTableModel(vdata, vheader));
        }

        public void foundMatch(String competitorName) {
                setDisplayState(State.WAITING_ACCEPT);
                lbFoundMatch.setText("Đã tìm thấy đối thủ " + competitorName + " . Vào ngay?");
        }

        private void stopAcceptPairMatchTimer() {
                if (acceptPairMatchTimer != null) {
                        acceptPairMatchTimer.cancel();
                }
        }

        @SuppressWarnings("rawtypes")
        private void startAcceptPairMatchTimer() {
                acceptPairMatchTimer = new CountDownTimer(acceptWaitingTime);
                acceptPairMatchTimer.setTimerCallBack(
                                // end callback
                                (Callable) () -> {
                                        // reset acceptPairMatchTimer
                                        acceptPairMatchTimer.restart();
                                        acceptPairMatchTimer.pause();

                                        // tự động từ chối nếu quá thời gian mà chưa chọn đồng ý
                                        if (!pairAcceptChoosed) {
                                                RunClient.socketHandler.declinePairMatch();
                                        }
                                        return null;
                                },
                                // tick callback
                                (Callable) () -> {
                                        lbTimerPairMatch.setText(acceptPairMatchTimer.getCurrentTick() + "s");
                                        return null;
                                },
                                // tick interval
                                1);
        }

        private void stopWaitingPairMatchTimer() {
                if (waitingPairTimer != null) {
                        waitingPairTimer.cancel();
                }
        }

        @SuppressWarnings("rawtypes")
        private void startWaitingPairMatchTimer() {
                waitingPairTimer = new CountDownTimer(5 * 60); // 5p
                waitingPairTimer.setTimerCallBack(
                                (Callable) () -> {
                                        setDisplayState(State.DEFAULT);
                                        JOptionPane.showMessageDialog(this, "Mãi chả thấy ai tìm trận.. Xui");
                                        return null;
                                },
                                (Callable) () -> {
                                        lbFindMatch.setText("Đang tìm trận.. "
                                                        + (5 * 60 - waitingPairTimer.getCurrentTick()) + "s");
                                        return null;
                                },
                                1);
        }

        public void setDisplayState(State s) {

                // mở hết lên
                LookAndFeel.enableComponents(plBtns, true);
                plFoundMatch.setVisible(true);
                plFindingMatch.setVisible(true);
                btnAcceptPairMatch.setEnabled(true);
                btnDeclinePairMatch.setEnabled(true);
                btnLogout.setEnabled(true);

                // xong đóng từng cái tùy theo state
                switch (s) {
                        case DEFAULT:
                                stopWaitingPairMatchTimer();
                                stopAcceptPairMatchTimer();
                                plFindingMatch.setVisible(false);
                                plFoundMatch.setVisible(false);
                                break;

                        case FINDING_MATCH:
                                startWaitingPairMatchTimer();
                                stopAcceptPairMatchTimer();
                                LookAndFeel.enableComponents(plBtns, false);
                                plFoundMatch.setVisible(false);
                                btnLogout.setEnabled(false);
                                break;

                        case WAITING_ACCEPT:
                                stopWaitingPairMatchTimer();
                                startAcceptPairMatchTimer();
                                pairAcceptChoosed = false;
                                LookAndFeel.enableComponents(plBtns, false);
                                plFindingMatch.setVisible(false);
                                btnLogout.setEnabled(false);
                                break;

                        case WAITING_COMPETITOR_ACCEPT:
                                LookAndFeel.enableComponents(plBtns, false);
                                pairAcceptChoosed = true;
                                plFindingMatch.setVisible(false);
                                btnAcceptPairMatch.setEnabled(false);
                                btnDeclinePairMatch.setEnabled(false);
                                btnLogout.setEnabled(false);
                                lbFoundMatch.setText("Đang chờ đối thủ..");
                                break;
                }
        }

        private void initComponents() {

                jPanel10 = new javax.swing.JPanel();
                jPanel4 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                plBtns = new javax.swing.JPanel();
                btnCreateRoom = new javax.swing.JButton();
                btnFindMatch = new javax.swing.JButton();
                btnJoin = new javax.swing.JButton();
                btnWatch = new javax.swing.JButton();
                jPanel1 = new javax.swing.JPanel();
                btnLogout = new javax.swing.JButton();
                btnProfile = new javax.swing.JButton();
                plFindingMatch = new javax.swing.JPanel();
                jProgressBar1 = new javax.swing.JProgressBar();
                lbFindMatch = new javax.swing.JLabel();
                jProgressBar2 = new javax.swing.JProgressBar();
                btnCancelFindMatch = new javax.swing.JButton();
                tpRoomAndUser = new javax.swing.JTabbedPane();
                jPanel5 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tbListRoom = new javax.swing.JTable();
                btnRefreshListRoom = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jList1 = new javax.swing.JList<>();
                jButton1 = new javax.swing.JButton();
                plFoundMatch = new javax.swing.JPanel();
                lbFoundMatch = new javax.swing.JLabel();
                btnDeclinePairMatch = new javax.swing.JButton();
                btnAcceptPairMatch = new javax.swing.JButton();
                lbTimerPairMatch = new javax.swing.JLabel();

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));
                jPanel10Layout.setVerticalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Caro Game");
                setResizable(false);

                plBtns.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

                btnCreateRoom
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_add_24px.png"))); // NOI18N
                btnCreateRoom.setText("Tạo phòng");

                btnFindMatch.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/client/view/asset/icons8_circled_play_24px.png"))); // NOI18N
                btnFindMatch.setText("Tìm trận");
                btnFindMatch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnFindMatchActionPerformed(evt);
                        }
                });

                btnJoin.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/client/view/asset/icons8_open_door_24px.png"))); // NOI18N
                btnJoin.setText("Vào phòng");

                btnWatch.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_vision_24px.png"))); // NOI18N
                btnWatch.setText("Vào xem");
                btnWatch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnWatchActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout plBtnsLayout = new javax.swing.GroupLayout(plBtns);
                plBtns.setLayout(plBtnsLayout);
                plBtnsLayout.setHorizontalGroup(
                                plBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plBtnsLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(btnFindMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnWatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnJoin)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnCreateRoom)
                                                                .addContainerGap()));
                plBtnsLayout.setVerticalGroup(
                                plBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plBtnsLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(plBtnsLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCreateRoom)
                                                                                .addComponent(btnFindMatch)
                                                                                .addComponent(btnJoin)
                                                                                .addComponent(btnWatch))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                btnLogout.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/client/view/asset/icons8_logout_rounded_left_24px.png"))); // NOI18N
                btnLogout.setText("Đăng xuất");
                btnLogout.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLogoutActionPerformed(evt);
                        }
                });

                btnProfile.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_contact_24px.png"))); // NOI18N
                btnProfile.setText("Hồ sơ");
                btnProfile.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnProfileActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(btnLogout)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnProfile)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnLogout)
                                                                                .addComponent(btnProfile))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jProgressBar1.setIndeterminate(true);

                lbFindMatch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                lbFindMatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbFindMatch.setText("Đang tìm trận...");

                jProgressBar2.setIndeterminate(true);

                btnCancelFindMatch.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_cancel_24px.png"))); // NOI18N
                btnCancelFindMatch.setText("Hủy");
                btnCancelFindMatch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelFindMatchActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout plFindingMatchLayout = new javax.swing.GroupLayout(plFindingMatch);
                plFindingMatch.setLayout(plFindingMatchLayout);
                plFindingMatchLayout.setHorizontalGroup(
                                plFindingMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plFindingMatchLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jProgressBar1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                189,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnCancelFindMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jProgressBar2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(5, 5, 5))
                                                .addGroup(plFindingMatchLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(lbFindMatch,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                plFindingMatchLayout.setVerticalGroup(
                                plFindingMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plFindingMatchLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbFindMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plFindingMatchLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnCancelFindMatch)
                                                                                .addComponent(jProgressBar1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jProgressBar2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                tbListRoom.setAutoCreateRowSorter(true);
                tbListRoom.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                tbListRoom.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                {},
                                                {},
                                                {},
                                                {}
                                },
                                new String[] {

                                }));
                tbListRoom.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                tbListRoom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                jScrollPane1.setViewportView(tbListRoom);

                btnRefreshListRoom.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_replay_24px.png"))); // NOI18N
                btnRefreshListRoom.setText("Làm mới");
                btnRefreshListRoom.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRefreshListRoomActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel5Layout.createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(btnRefreshListRoom))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                474,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                222, Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnRefreshListRoom)
                                                                .addContainerGap()));

                tpRoomAndUser.addTab("Danh sách phòng", jPanel5);

                jList1.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

                        public int getSize() {
                                return strings.length;
                        }

                        public String getElementAt(int i) {
                                return strings[i];
                        }
                });
                jScrollPane2.setViewportView(jList1);

                jButton1.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_contact_24px.png"))); // NOI18N
                jButton1.setText("Xem thông tin");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane2)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel3Layout.createSequentialGroup()
                                                                                                                .addGap(0, 338, Short.MAX_VALUE)
                                                                                                                .addComponent(jButton1)))
                                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                298,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton1)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                tpRoomAndUser.addTab("Người chơi", jPanel3);

                lbFoundMatch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                lbFoundMatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbFoundMatch.setText("Đã tìm thấy đối thủ ... Vào ngay?");

                btnDeclinePairMatch.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_cancel_24px.png"))); // NOI18N
                btnDeclinePairMatch.setText("Từ chối");
                btnDeclinePairMatch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDeclinePairMatchActionPerformed(evt);
                        }
                });

                btnAcceptPairMatch
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/client/view/asset/icons8_ok_24px.png"))); // NOI18N
                btnAcceptPairMatch.setText("Chấp nhận");
                btnAcceptPairMatch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAcceptPairMatchActionPerformed(evt);
                        }
                });

                lbTimerPairMatch.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
                lbTimerPairMatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbTimerPairMatch.setText("15s");

                javax.swing.GroupLayout plFoundMatchLayout = new javax.swing.GroupLayout(plFoundMatch);
                plFoundMatch.setLayout(plFoundMatchLayout);
                plFoundMatchLayout.setHorizontalGroup(
                                plFoundMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plFoundMatchLayout.createSequentialGroup()
                                                                .addGap(131, 131, 131)
                                                                .addComponent(btnDeclinePairMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnAcceptPairMatch)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFoundMatchLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(plFoundMatchLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(lbFoundMatch,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(lbTimerPairMatch,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                plFoundMatchLayout.setVerticalGroup(
                                plFoundMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plFoundMatchLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbFoundMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbTimerPairMatch)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plFoundMatchLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnDeclinePairMatch)
                                                                                .addComponent(btnAcceptPairMatch))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(tpRoomAndUser,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0, Short.MAX_VALUE)
                                                                                .addComponent(plFindingMatch,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(plBtns,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(plFoundMatch,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(plBtns,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(plFindingMatch,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(plFoundMatch,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tpRoomAndUser,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                306,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }

        private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
                RunClient.socketHandler.logout();
        }

        private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {
                RunClient.openScene(RunClient.SceneName.PROFILE);
                RunClient.profileScene.loadProfileData(RunClient.socketHandler.getLoginEmail());
        }

        private void btnFindMatchActionPerformed(java.awt.event.ActionEvent evt) {
                // chỉ gửi yêu cầu lên server chứ ko đổi giao diện ngay
                // socketHandler sẽ đọc kết quả trả về từ server và quyết định có đổi
                // stateDisplay hay không
                RunClient.socketHandler.findMatch();
        }

        private void btnCancelFindMatchActionPerformed(java.awt.event.ActionEvent evt) {
                // chỉ gửi yêu cầu lên server chứ ko đổi giao diện ngay
                // socketHandler sẽ đọc kết quả trả về từ server và quyết định có đổi
                // stateDisplay hay không
                RunClient.socketHandler.cancelFindMatch();
        }

        private void btnDeclinePairMatchActionPerformed(java.awt.event.ActionEvent evt) {
                setDisplayState(State.DEFAULT);
                RunClient.socketHandler.declinePairMatch();
        }

        private void btnAcceptPairMatchActionPerformed(java.awt.event.ActionEvent evt) {
                setDisplayState(State.WAITING_COMPETITOR_ACCEPT);
                RunClient.socketHandler.acceptPairMatch();
        }

        private void btnWatchActionPerformed(java.awt.event.ActionEvent evt) {
                // https://stackoverflow.com/a/38981623
                int column = 0;
                int row = tbListRoom.getSelectedRow();
                if (row >= 0) {
                        String roomId = tbListRoom.getModel().getValueAt(row, column).toString();
                        RunClient.socketHandler.watchRoom(roomId);
                }
        }

        private void btnRefreshListRoomActionPerformed(java.awt.event.ActionEvent evt) {
                RunClient.socketHandler.listRoom();
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
                        java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new MainMenu().setVisible(true);
                        }
                });
        }

        private javax.swing.JButton btnAcceptPairMatch;
        private javax.swing.JButton btnCancelFindMatch;
        private javax.swing.JButton btnCreateRoom;
        private javax.swing.JButton btnDeclinePairMatch;
        private javax.swing.JButton btnFindMatch;
        private javax.swing.JButton btnJoin;
        private javax.swing.JButton btnLogout;
        private javax.swing.JButton btnProfile;
        private javax.swing.JButton btnRefreshListRoom;
        private javax.swing.JButton btnWatch;
        private javax.swing.JButton jButton1;
        private javax.swing.JList<String> jList1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JProgressBar jProgressBar1;
        private javax.swing.JProgressBar jProgressBar2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lbFindMatch;
        private javax.swing.JLabel lbFoundMatch;
        private javax.swing.JLabel lbTimerPairMatch;
        private javax.swing.JPanel plBtns;
        private javax.swing.JPanel plFindingMatch;
        private javax.swing.JPanel plFoundMatch;
        private javax.swing.JTable tbListRoom;
        private javax.swing.JTabbedPane tpRoomAndUser;

}
