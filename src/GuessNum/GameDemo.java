package GuessNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class GameDemo {
    private String token;
    private int round;
    private BufferedReader in;
    private PrintWriter out;
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public GameDemo(){
        this.round=0;
        setToken();
    }

    public int[] checkToken(String s){
        String tmp=this.getToken();
        int a=0,b=0;
        Vector<Character> v=new Vector<>();
        for(int i=0;i<5;i++){
            if(tmp.charAt(i)==s.charAt(i)){
                a++;
            }
            else{
                v.add(tmp.charAt(i));
            }
        }
        for(int i=0;i<5;i++){
            if(tmp.charAt(i)!=s.charAt(i)){
                for(int j=0;j<v.size();j++){
                    if(v.get(j)==s.charAt(i)){
                        b++;
                        v.removeElementAt(j);
                        break;
                    }
                }
            }
        }
        return new int[]{a,b};
    }

    public String getToken() {
        return token;
    }


    public void setToken() {
        token="";
        int cnt=5;
        while(cnt>0){
            cnt--;
            Integer k=(int)(Math.random()*10);
            token+=k.toString();
        }
    }

    public String printResult(int[] a){
        return a[0]+"r"+a[1]+"d";
    }

    public void run() throws IOException {
        this.setToken();
        this.setRound(0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Game start!");
        while(true){
            this.setRound(this.getRound()+1);
            System.out.println("Round "+this.getRound()+": Make a guess.");
            String guess=br.readLine();
            int[] a=checkToken(guess);
            if(a[0]==5){
                System.out.println("You win with "+getRound()+" rounds");
                break;
            }
            System.out.println("The result of your guess is: "+printResult(a));
        }
    }

    public static void main(String[] args) {
        GameDemo a=new GameDemo();
        try {
            a.run();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
