package GuessNum;

public class Game {
    private String token;
    private int round;

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

    public Game(){
        this.round=0;
        this.setToken();
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
