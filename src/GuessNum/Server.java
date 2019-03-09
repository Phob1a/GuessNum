package GuessNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @
 */
public class Server {

    private HashMap<String,Socket> clients = new HashMap<>();
    private static Server server = null;
    private GameDemo game;
    private BufferedReader in;
    private PrintWriter out;

    static final int len=5;

    public static Server getInstance(){
        if(server == null){
            server = new Server();
        }
        return server;
    }

    /**
     * Get the client
     * @return
     */
    public HashMap<String, Socket> getClients() {
        return clients;
    }

    public void Start(int port){
        game=new GameDemo();

        try {
            ServerSocket ss = new ServerSocket(port);
            Socket c=ss.accept();
            this.in=new BufferedReader(new InputStreamReader(c.getInputStream()));
            this.out=new PrintWriter(c.getOutputStream(),true);
            out.println("Connected!");
            while(true){
                game.setRound(game.getRound()+1);
                //out.println("Make a guess: ");
                String x=in.readLine();
                System.out.println(x);
                int[] f=this.game.checkToken(x);
                String res=game.printResult(f);
                if(f[0]==len){
                    out.println("You win in "+game.getRound()+" rounds, correct token is: "+x);
                    ss.close();
                }
                else{
                    out.println("Round "+game.getRound()+": "+res);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

       Server.getInstance().Start(4096);
    }
}