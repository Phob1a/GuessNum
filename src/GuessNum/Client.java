package GuessNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader br;
    private ExecutorService es = Executors.newFixedThreadPool(5, r -> {
        Thread t = Executors.defaultThreadFactory().newThread(r);
        t.setDaemon(true);
        return t;
    });


    public Client(String ip,int port) throws IOException {
        this.socket=new Socket(ip,port);
        this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.br=new BufferedReader(new InputStreamReader(System.in));
        this.out=new PrintWriter(socket.getOutputStream(),true);
    }

    public void start(int port) throws IOException {
       while(true){
            String f=in.readLine();
            //System.out.println("Make a guess: ");
            System.out.println(f);
            String t=br.readLine();
            out.println(t);
            //f=in.readLine();
            //System.out.println(f);
       }
    }

    public static void main(String[] args) throws IOException {
        Client c=new Client("localhost",4096);
        c.start(4096);
    }

}
