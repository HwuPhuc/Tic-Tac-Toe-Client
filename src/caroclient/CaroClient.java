
package caroclient;

import java.io.IOException;
import view.*;

public class CaroClient{

        public static User user;
        
        public static frmLobby Lobby;
        public static frmLogin Login;
        public static frmRegister Register;
        public static frmWaitingRoom WaitingRoom;
        public static frmJoinRoom Join;
        public static frmRoom Room;
        public static frmUserInfo UserInfo;
        public static frmCreateRoom CreateRoom;
        
        public static ClientSocket clientSocket;
                
    public static void main(String[] args) throws IOException {
        Login = new frmLogin();
        Login.setVisible(true);
        clientSocket = new ClientSocket();
        clientSocket.run();
    }
    public static void openForm(Form frm){
        if (frm != null){
            switch (frm){
                case LoginForm:
                    Login = new frmLogin();
                    Login.setVisible(true);
                    break;
                case RegisterForm:
                    Register = new frmRegister();
                    Register.setVisible(true);
                    break;
                case LobbyForm:
                    Lobby = new frmLobby();
                    Lobby.setVisible(true);
                    break;
                case JoinForm:
                    Join = new frmJoinRoom();
                    Join.setVisible(true);
                    break;
                case UserInfoForm:
                    UserInfo = new frmUserInfo(user.getUserID(),user.getUserName(),user.getAccountName(),user.getGamePlayed(),user.getWinningGame(),user.getDrawedGame());
                    UserInfo.setVisible(true);
                    break;
                case CreateRoomForm:
                    CreateRoom = new frmCreateRoom();
                    CreateRoom.setVisible(true);
                    break;
            }
        }
    }
    public static void openForm(Form frm, String player1, String player2){
        if (frm == Form.WaitingRoomForm){
            WaitingRoom = new frmWaitingRoom(player1, player2);
            WaitingRoom.setVisible(true);
        }
    }
    public static void openForm(Form frm, int roomID, String player1, String player2){
        if (frm == Form.Room){
            Room = new frmRoom(roomID, player1, player2);
            Room.setVisible(true);
        }
    }
    public static void closeForm(Form frm){
        if (frm != null){
            switch (frm){
                case LoginForm:
                    Login.dispose();
                    break;
                case RegisterForm:
                    Register.dispose();
                    break;
                case LobbyForm:
                    Lobby.dispose();
                    break;
                case Room:
                    Room.dispose();
                    break;
                case JoinForm:
                    Join.dispose();
                    break;
                case WaitingRoomForm:
                    WaitingRoom.dispose();
                    break;
                case UserInfoForm:
                    UserInfo.dispose();
                    break;
                case CreateRoomForm:
                    CreateRoom.dispose();
                    break;
            }
        }
    }
    public static void closeAll(){
        if(Login != null) Login.dispose();
        if(Lobby != null) Lobby.dispose();
        if(Register != null) Register.dispose();
        if(WaitingRoom != null) WaitingRoom.dispose();
        if(UserInfo != null) UserInfo.dispose();
        if(CreateRoom != null) CreateRoom.dispose();
        if(Room != null) Room.dispose();
        if(Join != null) Join.dispose();
    }
    public enum Form{
        LoginForm,
        RegisterForm,
        LobbyForm,
        Room,
        JoinForm,
        WaitingRoomForm,
        UserInfoForm,
        CreateRoomForm,
    }
}
