import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int num;
    String response;
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void start(int port){
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket socket=ss.accept();
            setNum((int)(Math.random()*100));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.write("Guess a number(1~100)");
            while(true){
                String[] tmp=in.readLine().split(",");
                if(tmp[0]==null) break;
                int guess=Integer.parseInt(tmp[0]);
                int attempt=Integer.parseInt(tmp[1]);
                if(attempt>=3){
                    response="You lose.";
                    out.println(response);
                }
                if(guess==getNum()){
                    response="Congratulation!";
                    out.println(response);
                }
                else if(guess<getNum()){
                    response="Oh! Too small!";
                    out.println(response);
                }
                else{
                    response="Oh! Too big!";
                    out.println(response);
                }
            }
            ss.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start(4096);
    }

}
