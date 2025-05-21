package caroclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClientSocket implements Runnable {
    private Socket socketOfClient;
    private BufferedWriter out;

    @Override
    public void run() {
        try {
            String IPServer = "Put your IP of the device that is running the code of the server";
            socketOfClient = new Socket(IPServer, 7777);
            System.out.println("Connected!");
            out = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            String msg;
            while (true) {
                msg = in.readLine();
                if (msg == null) {
                    break;
                }
                System.out.println(msg);
                String msgSplit[] = msg.split(",");
                if (msgSplit[0].equals("Login successfully")) {
                    System.out.println("Login successfully");
                    CaroClient.closeForm(CaroClient.Form.LoginForm); // Đóng form đăng nhập
                    CaroClient.openForm(CaroClient.Form.LobbyForm); // Mở form sảnh chính (Lobby)
                    CaroClient.user = new User(
                            Integer.parseInt(msgSplit[1]),
                            msgSplit[2],
                            msgSplit[3],
                            msgSplit[4],
                            Integer.parseInt(msgSplit[5]),
                            Integer.parseInt(msgSplit[6]),
                            Integer.parseInt(msgSplit[7]));

                }
                if (msg.equals("duplicate login")) {
                    JOptionPane.showMessageDialog(CaroClient.Login, "Tài khoản đã được đăng nhập ở nơi khác");
                }
                if (msgSplit[0].equals("Wrong account name or password")) {
                    JOptionPane.showMessageDialog(CaroClient.Login, "Sai mật khẩu hoặc tài khoản, vui lòng nhập lại");
                }
                if (msgSplit[0].equals("Register successfully")) {
                    System.out.println("Register successfully");
                    JOptionPane.showMessageDialog(CaroClient.Register,
                            "Đăng ký tài khoản thành công, hãy đăng nhâp với tài khoản vừa tạo để chơi");
                    CaroClient.closeForm(CaroClient.Form.RegisterForm);
                    CaroClient.openForm(CaroClient.Form.LoginForm);
                }
                if (msg.equals("This account name is existed")) {
                    System.out.println("Someone else is using this account name");
                    JOptionPane.showMessageDialog(CaroClient.Register,
                            "Tên tài khoản này đã được sử dụng, vui lòng dùng tên tài khoản khác!");
                }
                if (msg.equals("This username is existed")) {
                    System.out.println("Someone else is using this username");
                    JOptionPane.showMessageDialog(CaroClient.Register,
                            "Tên người chơi này đã được sử dụng, vui lòng dùng tên khác!");
                }
                if (msgSplit[0].equals("Room created successfully")) {
                    System.out.println("Room created successfully");
                    CaroClient.closeForm(CaroClient.Form.CreateRoomForm);
                    CaroClient.openForm(CaroClient.Form.WaitingRoomForm, msgSplit[msgSplit.length - 1], null);
                    CaroClient.WaitingRoom.setRoomID(Integer.parseInt(msgSplit[1]));
                    CaroClient.WaitingRoom.setRoomPassword(msgSplit[2]);
                    CaroClient.WaitingRoom.setPlayer1Info(CaroClient.user.getUserName());
                }
                if (msgSplit[0].equals("joined room")) {
                    System.out.println("Joined room " + msgSplit[1]);
                    CaroClient.closeForm(CaroClient.Form.JoinForm);
                    CaroClient.openForm(CaroClient.Form.WaitingRoomForm, msgSplit[3], msgSplit[4]);
                    CaroClient.WaitingRoom.setRoomID(Integer.parseInt(msgSplit[1]));
                    CaroClient.WaitingRoom.setRoomPassword(msgSplit[2]);
                    CaroClient.WaitingRoom.setPlayer1Info(msgSplit[3]);
                    CaroClient.WaitingRoom.setPlayer2Info(msgSplit[4] + "(You)");
                }
                if (msg.equals("Room not existed")) {
                    JOptionPane.showMessageDialog(CaroClient.Join, "Không tìm thấy phòng này hoặc phòng đã đầy!");
                }
                if (msgSplit[0].equals("a friend joined your room")) {
                    System.out.println("A friend has just joined room " + msgSplit[1]);
                    CaroClient.closeForm(CaroClient.Form.WaitingRoomForm);
                    CaroClient.openForm(CaroClient.Form.WaitingRoomForm, msgSplit[3], msgSplit[4]);
                    CaroClient.WaitingRoom.setRoomID(Integer.parseInt(msgSplit[1]));
                    CaroClient.WaitingRoom.setRoomPassword(msgSplit[2]);
                    CaroClient.WaitingRoom.setPlayer1Info(msgSplit[3] + "(You)");
                    CaroClient.WaitingRoom.setPlayer2Info(msgSplit[4]);
                }
                if (msgSplit[0].equals("your opponent is ready")) {
                    CaroClient.WaitingRoom.updateMSG("Đối thủ " + msgSplit[1] + " đã sẵn sàng");
                }
                if (msgSplit[0].equals("match begin")) {
                    CaroClient.closeForm(CaroClient.Form.WaitingRoomForm);
                    CaroClient.openForm(CaroClient.Form.Room, Integer.parseInt(msgSplit[1]), msgSplit[3], msgSplit[5]);
                }
                if (msgSplit[0].equals("caro")) {
                    CaroClient.Room.addOpponentMove(msgSplit[1], Integer.parseInt(msgSplit[2]),
                            Integer.parseInt(msgSplit[3]));
                    CaroClient.Room.turnToPlay(true);
                }
                if (msgSplit[0].equals("win")) {
                    CaroClient.Room.addOpponentMove(msgSplit[1], Integer.parseInt(msgSplit[2]),
                            Integer.parseInt(msgSplit[3]));
                    CaroClient.Room.turnToPlay(false);
                    JOptionPane.showMessageDialog(CaroClient.Room, "Bạn đã thua!");
                    CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                }
                if (msgSplit[0].equals("draw")) {
                    CaroClient.Room.addOpponentMove(msgSplit[1], Integer.parseInt(msgSplit[2]),
                            Integer.parseInt(msgSplit[3]));
                    CaroClient.Room.turnToPlay(false);
                    JOptionPane.showMessageDialog(CaroClient.Room, "Trận đấu kết thúc! Kết quả hòa!");
                    CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                    CaroClient.user.setDrawedGame(CaroClient.user.getDrawedGame() + 1);
                }
                if (msg.equals("your opponent left the room")) {
                    JOptionPane.showMessageDialog(CaroClient.Room, "Đối thủ của bạn đã rời phòng nên phòng sẽ bị hủy!");
                    CaroClient.closeAll();
                    CaroClient.openForm(CaroClient.Form.LobbyForm);
                }
                if (msgSplit[0].equals("chatWR")) {
                    CaroClient.WaitingRoom.updateMSG(msgSplit[1] + ": " + msgSplit[2]);
                }
                if (msgSplit[0].equals("chatRoom")) {
                    CaroClient.Room.updateMSG(msgSplit[1] + ": " + msgSplit[2]);
                }
                if (msgSplit[0].equals("you win bc your opponent have forfeited the game")) {
                    JOptionPane.showMessageDialog(CaroClient.Room, "Bạn đã thắng do đối thủ của bạn bỏ cuộc!");
                    CaroClient.closeAll();
                    CaroClient.openForm(CaroClient.Form.LobbyForm);
                    CaroClient.user.setGamePlayed(CaroClient.user.getGamePlayed() + 1);
                    CaroClient.user.setWinningGame(CaroClient.user.getWinningGame() + 1);
                }
                if (msg.equals("your opponent left the game room")) {
                    JOptionPane.showMessageDialog(CaroClient.Room, "Đối thủ của bạn đã rời phòng nên phòng sẽ bị hủy!");
                    CaroClient.closeAll();
                    CaroClient.openForm(CaroClient.Form.LobbyForm);
                }
                if (msg.equals("server closed")) {
                    JOptionPane.showMessageDialog(CaroClient.Lobby, "Server tạm thời đóng để bảo trì!", "Thông báo!",
                            JOptionPane.OK_OPTION);
                    CaroClient.closeAll();
                    socketOfClient.close();
                    out.close();
                    in.close();
                }
            }
        } catch (IOException ex) {

        }
    }

    public void write(String msgToSend) throws IOException {
        out.write(msgToSend);
        out.newLine();
        out.flush();
    }
}
