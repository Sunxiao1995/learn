package club.banyuan;
import java.util.Scanner;

public class Player{
    private final int RECORD_COUNT = 10;
    private String playerName;
    private String[] record ;
    //private int playCount = 0;
    private boolean winOrNot = true;

   public Player(String playerName){
       this.playerName = playerName;
       record = new String[RECORD_COUNT];
   }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String[] getRecord() {
        return record;
    }

//    public void setRecord(String record , int playCount) {
//        this.record[playCount] = record;
//    }

    public boolean isWinOrNot() {
        return winOrNot;
    }

    public void setWinOrNot(boolean winOrNot) {
        this.winOrNot = winOrNot;
    }

    public String playerFingerGuess(String playerChoose,int playCount){
       switch(playerChoose){
           case("1"):
               record[playCount] = "剪刀";
               break;
           case("2"):
               record[playCount] = "石头";
               break;
           case("3"):
               record[playCount] = "布";
               break;
       }
       return record[playCount];

    }

}

