package club.banyuan;
import java.util.Scanner;

public class Rules {
  static boolean returnFirstMenu;
  private static int playsCount;

  public static int getPlaysCount() {
    return playsCount;
  }

  public static void setPlaysCount(int playsCount) {
    Rules.playsCount = playsCount;
  }

  // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
  public static int playersCountInit() {
    int playerCount;
    while(true){
      System.out.println("用户输入多少人参与猜拳（2~5人）。输入0退出程序");
      Scanner scanner = new Scanner(System.in);
      String  a = scanner.nextLine();
      if(a.equals("0")){//输入0退出程序
        System.exit(0);
      }else if(a.equals("2") || a.equals("3")||a.equals("4")||a.equals("5") ){
        playerCount = Integer.parseInt(a);
        break;
      }else{
        System.out.println("非法输入");
      }
    }
    return playerCount;
  }

  static void showFingers(Player[] players) {
    System.out.printf("当前游戏%d人参与猜拳\n", Rules.getPlaysCount());//每轮猜拳开始之前，输出当前参与游戏人数
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      player.showFinger();//每名玩家出拳

    }
  }



  static void printWinner(Player[] players) {
    // 输出获胜方
    for (Player player : players) {
      if (!player.isOut()) {
        System.out.println("获胜方是" + player.getRole() + player.getId());
      }
    }
  }

  static boolean isFinalWinner(Player[] players) {
    int winnerCount = 0;
    for (Player player : players) {
      if (!player.isOut()) {
        winnerCount++;
      }
    }
    return winnerCount == 1;
  }

  static boolean isDraw(String rlt) {
    return rlt.length() == 3 || rlt.length() == 1;
  }

  static void outPlayer(Player[] players, String rlt) {
    int winnerFinger = getWinnerFinger(rlt);
    for (Player player : players) {
      if (!player.isOut() && player.getFinger() != winnerFinger) {
        player.setOut(true);
        int countLeft = getPlaysCount();
        setPlaysCount(countLeft - 1);
        System.out.println(
            player.toString() + "输掉了");
      } else if (!player.isOut()) {
        System.out.println(
            player.toString() + "胜利");
      }
    }
  }


  static String competeResult(Player[] players) {
    StringBuilder rlt = new StringBuilder();
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      String oneFinger = player.getFinger() + "";
      if (!rlt.toString().contains(oneFinger)) {
        rlt.append(oneFinger);
      }
    }
    return rlt.toString();
  }

  //  12 21 = 1
  //  13 31 = 3
  //  23 32 = 2
  private static int getWinnerFinger(String rlt) {
    if ("12".equals(rlt) || "21".equals(rlt)) {

      return 1;
    } else if ("13".equals(rlt) || "31".equals(rlt)) {
      return 3;
    } else {
      return 2;
    }
  }
}
