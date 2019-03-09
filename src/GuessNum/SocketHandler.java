package GuessNum;

import java.net.Socket;

public class SocketHandler extends Thread{

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket=socket;
    }

    public void start() {


    }
}
