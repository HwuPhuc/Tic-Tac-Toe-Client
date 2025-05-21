
package view;

import caroclient.CaroClient;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class frmRegister extends javax.swing.JFrame {

    public frmRegister() {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAccountReg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsernameReg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPasswordReg = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtPasswordRegConfirm = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        radHidePasswordReg = new javax.swing.JRadioButton();
        radHidePasswordRegConfirm = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Đăng ký");

        jLabel2.setText("Tài khoản");

        jLabel3.setText("Tên người dùng (hiển thị trong game)");

        jLabel4.setText("Mật khẩu");

        jLabel5.setText("Nhập lại mật khẩu");

        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        radHidePasswordReg.setSelected(true);
        radHidePasswordReg.setText("Ẩn mật khẩu");
        radHidePasswordReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHidePasswordRegActionPerformed(evt);
            }
        });

        radHidePasswordRegConfirm.setSelected(true);
        radHidePasswordRegConfirm.setText("Ẩn mật khẩu");
        radHidePasswordRegConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHidePasswordRegConfirmActionPerformed(evt);
            }
        });

        jLabel6.setText("Đã có tài khoản?");

        lblLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblLogin.setText("Đăng nhập");
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radHidePasswordReg)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPasswordRegConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(txtAccountReg, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(txtUsernameReg)
                                .addComponent(txtPasswordReg))
                            .addComponent(radHidePasswordRegConfirm)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnRegister))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblLogin)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAccountReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsernameReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPasswordReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radHidePasswordReg)
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPasswordRegConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radHidePasswordRegConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblLogin))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radHidePasswordRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHidePasswordRegActionPerformed
        if(!radHidePasswordReg.isSelected()){
            txtPasswordReg.setEchoChar((char)0);
        }
        else{
            txtPasswordReg.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_radHidePasswordRegActionPerformed

    private void radHidePasswordRegConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHidePasswordRegConfirmActionPerformed
        if(!radHidePasswordRegConfirm.isSelected()){
            txtPasswordRegConfirm.setEchoChar((char)0);
        }
        else{
            txtPasswordRegConfirm.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_radHidePasswordRegConfirmActionPerformed

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        lblLogin.setForeground(new Color(102,204,255));
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        lblLogin.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_lblLoginMouseExited

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        CaroClient.openForm(CaroClient.Form.LoginForm);
        CaroClient.closeForm(CaroClient.Form.RegisterForm);
    }//GEN-LAST:event_lblLoginMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        
        try{
            String accountReg = txtAccountReg.getText();
            String usernameReg = txtUsernameReg.getText();
            String passwordReg = String.copyValueOf(txtPasswordReg.getPassword());
            String passwordRegConfirm = String.copyValueOf(txtPasswordRegConfirm.getPassword());
            if(accountReg == null){
                JOptionPane.showMessageDialog(this, "Vui long nhap ten tai khoan");
            }
            else if (usernameReg == null) {
                JOptionPane.showMessageDialog(this, "Vui long nhap ten trong game");
            }
            else if (passwordReg == null) {
                JOptionPane.showMessageDialog(this, "Vui long nhap mat khau");
            }
            else if (passwordRegConfirm == null) {
                JOptionPane.showMessageDialog(this, "Vui long nhap lai mat khau de xac nhan");
            }
            else if (!passwordReg.equals(passwordRegConfirm)){
                JOptionPane.showMessageDialog(this, "Vui long nhap dung mat khau xac nhan");
            }
            else{
                CaroClient.clientSocket.write("register," + accountReg + "," + passwordReg + "," + usernameReg);
            }
        }
        catch (HeadlessException | IOException ex){
            
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JRadioButton radHidePasswordReg;
    private javax.swing.JRadioButton radHidePasswordRegConfirm;
    private javax.swing.JTextField txtAccountReg;
    private javax.swing.JPasswordField txtPasswordReg;
    private javax.swing.JPasswordField txtPasswordRegConfirm;
    private javax.swing.JTextField txtUsernameReg;
    // End of variables declaration//GEN-END:variables
}
