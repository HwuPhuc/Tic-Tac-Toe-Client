package view;

import caroclient.CaroClient;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class frmJoinRoom extends javax.swing.JFrame {

    public frmJoinRoom() {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnJoinRoom = new javax.swing.JButton();
        btnLeaveToLobby = new javax.swing.JButton();
        txtJoinRoom_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJoinRoom_Password = new javax.swing.JPasswordField();
        radHidePassword_Join = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vào phòng");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Vào phòng của bạn bè");

        btnJoinRoom.setText("Vào phòng");
        btnJoinRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinRoomActionPerformed(evt);
            }
        });

        btnLeaveToLobby.setText("Trở về sảnh");
        btnLeaveToLobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveToLobbyActionPerformed(evt);
            }
        });

        jLabel2.setText("Nhập ID Phòng");

        jLabel3.setText("Nhập mật khẩu phòng (nếu có)");

        radHidePassword_Join.setSelected(true);
        radHidePassword_Join.setText("Ẩn mật khẩu");
        radHidePassword_Join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHidePassword_JoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLeaveToLobby, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtJoinRoom_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(txtJoinRoom_Password))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnJoinRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radHidePassword_Join)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJoinRoom_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJoinRoom_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJoinRoom)
                    .addComponent(radHidePassword_Join)
                    .addComponent(btnLeaveToLobby))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radHidePassword_JoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHidePassword_JoinActionPerformed
        if(!radHidePassword_Join.isSelected()){
            txtJoinRoom_Password.setEchoChar((char)0);
        }
        else{
            txtJoinRoom_Password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_radHidePassword_JoinActionPerformed

    private void btnLeaveToLobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveToLobbyActionPerformed
        CaroClient.closeForm(CaroClient.Form.JoinForm);
        CaroClient.openForm(CaroClient.Form.LobbyForm);
    }//GEN-LAST:event_btnLeaveToLobbyActionPerformed

    private void btnJoinRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinRoomActionPerformed
        try {
            String roomID = txtJoinRoom_ID.getText();
            String roomPW = String.copyValueOf(txtJoinRoom_Password.getPassword());
            if(roomID.isEmpty()){
                JOptionPane.showMessageDialog(this, "ID phòng không thể để trống!");
            }
            else if(roomPW.isEmpty()){
                JOptionPane.showMessageDialog(this, "Mật khẩu phòng không thể để trống!");
            }
            else {
                CaroClient.clientSocket.write("join room," + roomID + "," + roomPW);
            }
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnJoinRoomActionPerformed

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
            java.util.logging.Logger.getLogger(frmJoinRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJoinRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJoinRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJoinRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJoinRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoinRoom;
    private javax.swing.JButton btnLeaveToLobby;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton radHidePassword_Join;
    private javax.swing.JTextField txtJoinRoom_ID;
    private javax.swing.JPasswordField txtJoinRoom_Password;
    // End of variables declaration//GEN-END:variables
}
