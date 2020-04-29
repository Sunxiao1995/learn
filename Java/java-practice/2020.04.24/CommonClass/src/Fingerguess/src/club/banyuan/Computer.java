package club.banyuan;
import java.util.Random;

public class Computer{
    private final int RECORD_COUNT = 10;
    private String computerName;
    private String[] record ;
    private boolean winOrNot = true;
    private int computer = 1;

    public Computer(){
        computerName = "电脑 "+computer;
        computer++;
        record = new String[RECORD_COUNT];
    }

    public String getComputerName() {
        return computerName;
    }

    public String[] getRecord() {
        return record;
    }

    public boolean isWinOrNot() {
        return winOrNot;
    }

    public void setWinOrNot(boolean winOrNot) {
        this.winOrNot = winOrNot;
    }
    public String computerFingerGuess(int playCount){
        if(winOrNot = false)
            return null;
        Random random = new Random();
        int computerChoose = random.nextInt(3);
        switch(computerChoose){
            case(0):
                record[playCount] = "剪刀";
                break;
            case(1):
                record[playCount] = "石头";
                break;
            case(2):
                record[playCount] = "布";
                break;
        }
        return record[playCount];

    }
}