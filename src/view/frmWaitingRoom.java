package view;

import caroclient.CaroClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.WindowConstants;

public class frmWaitingRoom extends javax.swing.JFrame {
    public static String player1;
    public static String player2;
    public static DefaultListModel<String> chat;
    public frmWaitingRoom(String p1, String p2) {
        initComponents();
        this.player1 = p1;
        this.player2 = p2;
        chat = new DefaultListModel<>();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        if(player1 == null || player2 == null){
            btnReadyToPlay.setEnabled(false);
            btnSendWRChat.setEnabled(false);
        }
        else{
            btnReadyToPlay.setEnabled(true);
            btnSendWRChat.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRoomID = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblSS = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPlayer2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listChat = new javax.swing.JList<>();
        txtChatWR = new javax.swing.JTextField();
        btnSendWRChat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnReadyToPlay = new javax.swing.JButton();
        btnLeaveRoom = new javax.swing.JButton();
        lblRoomPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRoomID.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblRoomID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomID.setText("Phòng: (ID Phòng)");

        lblPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlayer1.setText("Người chơi 1:");

        lblSS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSS.setText("Trạng thái:");

        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlayer2.setText("Người chơi 2:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Trạng thái:");

        jScrollPane1.setViewportView(listChat);

        btnSendWRChat.setText("Gửi");
        btnSendWRChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendWRChatActionPerformed(evt);
            }
        });

        jLabel6.setText("Trò chuyện");

        btnReadyToPlay.setText("Sẵn sàng");
        btnReadyToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadyToPlayActionPerformed(evt);
            }
        });

        btnLeaveRoom.setText("Rời");
        btnLeaveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveRoomActionPerformed(evt);
            }
        });

        lblRoomPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomPassword.setText("Mật khẩu: Không có");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblPlayer2)
                            .addComponent(lblSS)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayer1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRoomID)
                                    .addComponent(lblRoomPassword))
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReadyToPlay)
                                    .addComponent(btnLeaveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtChatWR, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSendWRChat, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomID)
                    .addComponent(btnLeaveRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomPassword)
                    .addComponent(btnReadyToPlay))
                .addGap(25, 25, 25)
                .addComponent(lblPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSS)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPlayer2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChatWR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendWRChat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadyToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadyToPlayActionPerformed
        try {
            CaroClient.clientSocket.write("ready," + lblRoomID.getText().split(" ")[1] + "," + CaroClient.user.getUserName());            
            btnReadyToPlay.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(frmWaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReadyToPlayActionPerformed

    private void btnLeaveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveRoomActionPerformed
        try {
            if(player2 == null){
                CaroClient.closeForm(CaroClient.Form.WaitingRoomForm);
                CaroClient.openForm(CaroClient.Form.LobbyForm);
            }
            else{
                CaroClient.clientSocket.write("left room," + lblRoomID.getText().split(" ")[1] + "," + CaroClient.user.getUserName());
                CaroClient.closeForm(CaroClient.Form.WaitingRoomForm);
                CaroClient.openForm(CaroClient.Form.LobbyForm);
            }
        } catch (IOException ex) {
            Logger.getLogger(frmWaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLeaveRoomActionPerformed

    private void btnSendWRChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendWRChatActionPerformed
        try {
            CaroClient.clientSocket.write("chatWR," + CaroClient.user.getUserName() + "," + txtChatWR.getText());
            updateMSG("Bạn: " + txtChatWR.getText());
            txtChatWR.setText("");
        } catch (IOException ex) {
            Logger.getLogger(frmWaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendWRChatActionPerformed
    public void updateMSG (String msg){
        chat.addElement(msg);
        listChat.setModel(chat);
    }
    public void setRoomID(int uid){
        lblRoomID.setText("Phòng: " + String.valueOf(uid));
    }
    public void setRoomPassword(String pass){
        lblRoomPassword.setText("Mật khẩu: " + pass);
    }
    public void setPlayer1Info(String info){
        lblPlayer1.setText("Người chơi 1: " + info);
    }
    public void setPlayer2Info(String info){
        lblPlayer2.setText("Người chơi 2: " + info);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmWaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmWaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmWaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmWaitingRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmWaitingRoom(player1, player2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeaveRoom;
    private javax.swing.JButton btnReadyToPlay;
    private javax.swing.JButton btnSendWRChat;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblRoomID;
    private javax.swing.JLabel lblRoomPassword;
    private javax.swing.JLabel lblSS;
    private javax.swing.JList<String> listChat;
    private javax.swing.JTextField txtChatWR;
    // End of variables declaration//GEN-END:variables
}
