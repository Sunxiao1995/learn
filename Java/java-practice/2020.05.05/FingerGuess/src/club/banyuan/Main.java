package club.banyuan;

import java.util.Scanner;

public class Main {
  // TODO
  // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
  // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
  // 3. 用户猜拳界面，输入0，返回到上一级，重新开始选择参与人数
  // 4. 用户进入到猜拳界面，提示当前的人数的信息，例如"当前游戏3人猜拳"，每次猜拳下一轮开始时，显示本轮剩余玩家数量，
  public static void main(String[] args) {
    while (true) {
      Rules.returnFirstMenu = false;//true为返回主界面，false为不返回主界面

      // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
      int playerCount = Rules.playersCountInit();
      Rules.setPlaysCount(playerCount);
      Player[] players = Player.initPlayers(playerCount);

      while (true) {
        Rules.showFingers(players);
        if (Rules.returnFirstMenu) {//如果要回到主界面，则跳出出拳的循环
          break;
        } else {
          String rlt = Rules.competeResult(players);

          if (Rules.isDraw(rlt)) {
            System.out.println("平局");
            continue;
          } else {
            Rules.outPlayer(players, rlt);
          }
          if (Rules.isFinalWinner(players)) {
            break;
          }
        }
      }

      if (Rules.returnFirstMenu) {//如果要回到主界面，则继续外层循环
        continue;
      }
      Rules.printWinner(players);
      break;//保证如过顺利输出获胜者，游戏不会重复进行
    }
  }
}

