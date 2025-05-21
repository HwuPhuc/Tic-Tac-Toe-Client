
package view;

import caroclient.CaroClient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class frmRoom extends javax.swing.JFrame {
    public static int roomID;
    public static String player1; // X
    public static String player2; // O
    
    private final int size = 15;
    private int enabledSquare = (int)Math.pow(size, 2);
    private final JButton[][] button;
    private int[][] table;
    
    public static DefaultListModel<String> chat;
    
    public frmRoom(int rid, String p1, String p2) {
        initComponents();
        this.roomID = rid;
        this.player1 = p1;
        this.player2 = p2;
        chat = new DefaultListModel<>();
        
        lblPlayer1.setText(player1);
        lblPlayer2.setText(player2);
        
        this.setTitle("Cờ Caro");
        panelGameplay.setPreferredSize(new Dimension(492,492));
        panelGameplay.setLayout(new GridLayout(size, size));
        
        table = new int[size][size];
        button = new JButton[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                button[i][j] = new JButton("");
                table[i][j] = 0;
                button[i][j].setFont(new Font("Nothworthy",Font.BOLD,18));
                button[i][j].setBackground(Color.lightGray);
                button[i][j].setPreferredSize(new Dimension(25,25));
                panelGameplay.add(button[i][j]);
            }
        }
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        buttonHandling();
        this.setSize(840, 515);
        this.setResizable(false);
        if(player1.equals(CaroClient.user.getUserName())){
            turnToPlay(true);
        }
        else{
            turnToPlay(false);
        }
    }
    private void buttonHandling(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                final int x = i, y = j;
                button[x][y].addActionListener((ActionEvent e) -> {
                    try {
                        addMyMove(CaroClient.user.getUserName(), x, y);
                        enabledSquare--;
                        button[x][y].setEnabled(false);
                        turnToPlay(false);
                        if(checkHang() || checkCot() || checkCheoTrai() || checkCheoPhai()){
                            CaroClient.clientSocket.write("win," + CaroClient.user.getUserName() + "," + x + "," + y);
                            JOptionPane.showMessageDialog(this, "Xin chúc mừng! Bạn đã thắng!");
                            CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                            CaroClient.user.setWinningGame(CaroClient.user.getWinningGame() + 1);
                        }
                        else if(enabledSquare == 0){
                            CaroClient.clientSocket.write("draw," + CaroClient.user.getUserName() + "," + x + "," + y);
                            JOptionPane.showMessageDialog(this, "Trận đấu kết thúc! Kết quả hòa!");
                            CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                            CaroClient.user.setDrawedGame(CaroClient.user.getDrawedGame() + 1);
                        }
                        else{
                            CaroClient.clientSocket.write("caro," + CaroClient.user.getUserName() + "," + x + "," + y);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                button[x][y].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        if (button[x][y].isEnabled()) {
                            button[x][y].setBackground(Color.GREEN);
                        }
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        if (button[x][y].isEnabled()) {
                            button[x][y].setBackground(Color.lightGray);
                        }
                    }
                });
            }
        }
    }
    public void addMyMove(String user, int x, int y){
        table[x][y] = 1;
        button[x][y].setEnabled(false);
        if(user.equals(player1)){
            button[x][y].setText("X");
            button[x][y].setBackground(Color.cyan);
        }
        else{
            button[x][y].setText("O");
            button[x][y].setBackground(Color.yellow);
        }
    }
    public void addOpponentMove(String user, int x, int y){
        table[x][y] = 2;
        button[x][y].setEnabled(false);
        if(user.equals(player1)){
            button[x][y].setText("X");
            button[x][y].setBackground(Color.cyan);
        }
        else{
            button[x][y].setText("O");
            button[x][y].setBackground(Color.yellow);
        }
    }
    public void turnToPlay(Boolean check){
        if(check){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(table[i][j] == 0){
                        button[i][j].setEnabled(true);
                    }
                }
            }
        }
        else{
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    button[i][j].setEnabled(false);
                }
            }
        }
    }
    private Boolean checkHang(){
        Boolean win = false;
        int hang = 0;
        boolean check = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (check) {
                    if (table[i][j] == 1) {
                        hang++;
                        if (hang > 4) {
                            win = true;
                            break;
                        }
                        continue;
                    } else {
                        check = false;
                        hang = 0;
                    }
                }
                if (table[i][j] == 1) {
                    check = true;
                    hang++;
                } else {
                    check = false;
                }
            }
            hang = 0;
        }
        return win;
    }
    private Boolean checkCot(){
        Boolean win = false;
        int cot = 0;
        boolean check = false;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (check) {
                    if (table[i][j] == 1) {
                        cot++;
                        if (cot > 4) {
                            win = true;
                            break;
                        }
                        continue;
                    } else {
                        check = false;
                        cot = 0;
                    }
                }
                if (table[i][j] == 1) {
                    check = true;
                    cot++;
                } else {
                    check = false;
                }
            }
            cot = 0;
        }
        return win;
    }
    public Boolean checkCheoPhai(){ // "/"
        Boolean win = false;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if(table[i][j] == 1){
                    if(i - 4 >= 0 && j + 4 <= 15 && table[i - 1][j + 1] == 1 && table[i - 2][j + 2] == 1 && table[i - 3][j + 3] == 1 && table[i - 4][j + 4] == 1){
                        win = true;
                        break;
                    }
                }
            }
        }
        return win;
    }
    public Boolean checkCheoTrai(){ // "\"
        Boolean win = false;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if(table[i][j] == 1){
                    if(i - 4 >= 0 && j - 4 >= 0 && table[i - 1][j - 1] == 1 && table[i - 2][j - 2] == 1 && table[i - 3][j - 3] == 1 && table[i - 4][j - 4] == 1){
                        win = true;
                        break;
                    }
                }
            }
        }
        return win;
    }
    
    private Boolean checkHangDoiThu(){
        Boolean win = false;
        int hang = 0;
        boolean check = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (check) {
                    if (table[i][j] == 2) {
                        hang++;
                        if (hang > 4) {
                            win = true;
                            break;
                        }
                        continue;
                    } else {
                        check = false;
                        hang = 0;
                    }
                }
                if (table[i][j] == 2) {
                    check = true;
                    hang++;
                } else {
                    check = false;
                }
            }
            hang = 0;
        }
        return win;
    }
    private Boolean checkCotDoiThu(){
        Boolean win = false;
        int cot = 0;
        boolean check = false;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (check) {
                    if (table[i][j] == 2) {
                        cot++;
                        if (cot > 4) {
                            win = true;
                            break;
                        }
                        continue;
                    } else {
                        check = false;
                        cot = 0;
                    }
                }
                if (table[i][j] == 2) {
                    check = true;
                    cot++;
                } else {
                    check = false;
                }
            }
            cot = 0;
        }
        return win;
    }
    public Boolean checkCheoPhaiDoiThu(){ // "/"
        Boolean win = false;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if(table[i][j] == 2){
                    if(i - 4 >= 0 && j + 4 <= 15 && table[i - 1][j + 1] == 2 && table[i - 2][j + 2] == 2 && table[i - 3][j + 3] == 2 && table[i - 4][j + 4] == 2){
                        win = true;
                        break;
                    }
                }
            }
        }
        return win;
    }
    public Boolean checkCheoTraiDoiThu(){ // "\"
        Boolean win = false;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if(table[i][j] == 2){
                    if(i - 4 >= 0 && j - 4 >= 0 && table[i - 1][j - 1] == 2 && table[i - 2][j - 2] == 2 && table[i - 3][j - 3] == 2 && table[i - 4][j - 4] == 2){
                        win = true;
                        break;
                    }
                }
            }
        }
        return win;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPlayer1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelGameplay = new javax.swing.JPanel();
        lblPlayer2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listChatRoom = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();
        btnChat = new javax.swing.JButton();
        btnExitRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPlayer1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lblPlayer1.setText("Your Username (You)");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelGameplay.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout panelGameplayLayout = new javax.swing.GroupLayout(panelGameplay);
        panelGameplay.setLayout(panelGameplayLayout);
        panelGameplayLayout.setHorizontalGroup(
            panelGameplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        panelGameplayLayout.setVerticalGroup(
            panelGameplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblPlayer2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lblPlayer2.setText("Opponent's Username");

        jScrollPane1.setViewportView(listChatRoom);

        jLabel3.setText("Trò chuyện");

        btnChat.setText("Gửi");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        btnExitRoom.setText("Thoát");
        btnExitRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGameplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPlayer1)
                        .addComponent(lblPlayer2)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addComponent(btnExitRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnExitRoom)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblPlayer1)
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblPlayer2)
                        .addGap(37, 37, 37))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelGameplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        try {
            CaroClient.clientSocket.write("chatRoom," + CaroClient.user.getUserName() + "," + txtChat.getText());
            updateMSG("Bạn: " + txtChat.getText());
            txtChat.setText("");
        } catch (IOException ex) {
            Logger.getLogger(frmRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnExitRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitRoomActionPerformed
        if(checkHang() || checkCot() || checkCheoPhai() || checkCheoTrai() || checkHangDoiThu()
                || checkCotDoiThu() || checkCheoPhaiDoiThu() || checkCheoTraiDoiThu()){
            //Kiem tra xem nguoi choi muon thoat phong khi tran dau da ket thuc hay chua
            int exit = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thoát phòng?",
                    "Thoát phòng?", JOptionPane.YES_NO_OPTION);
            if(exit == JOptionPane.YES_OPTION){
                try {
                    CaroClient.clientSocket.write("exit game room," + CaroClient.user.getUserName());
                    CaroClient.closeForm(CaroClient.Form.Room);
                    CaroClient.openForm(CaroClient.Form.LobbyForm);
                } catch (IOException ex) {
                    
                }
            }
        }
        else{
            int exit = JOptionPane.showConfirmDialog(rootPane,
                    "Bạn có muốn thoát? Trận đấu này chưa kết thúc và sẽ được tính vào thành tích của bạn như một trận thua!",
                    "Thoát trận đấu?", JOptionPane.YES_NO_OPTION);
            if(exit == JOptionPane.YES_OPTION){
                try {
                    CaroClient.clientSocket.write("exit mid game," + CaroClient.user.getUserName());
                    CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                    CaroClient.closeForm(CaroClient.Form.Room);
                    CaroClient.openForm(CaroClient.Form.LobbyForm);
                } catch (IOException ex) {
                    
                }
            }
        }
    }//GEN-LAST:event_btnExitRoomActionPerformed
    public void updateMSG (String msg){
        chat.addElement(msg);
        listChatRoom.setModel(chat);
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
            java.util.logging.Logger.getLogger(frmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRoom(roomID, player1, player2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnExitRoom;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JList<String> listChatRoom;
    private javax.swing.JPanel panelGameplay;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
