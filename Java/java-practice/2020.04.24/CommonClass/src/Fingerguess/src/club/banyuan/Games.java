package club.banyuan;

import java.util.Scanner;

public class Games{
    public Player A;      //用来保存用户
    public Computer[] computers = new Computer[4];    //用来保存电脑玩家
    public int peopleCount = 0; // 用来保存玩家的人数
    public int playCount = 0; //用来保存出拳进行的次数

    public void buildGamePeople(){             //创建玩家
         System.out.println("请输入多少人参与猜拳：");
         while(true) {
             Scanner scanner = new Scanner(System.in);
             peopleCount = scanner.nextInt();
             if (peopleCount > 5)
                 System.out.println("人数超过限制！请重新输入！");
             else
                 break;
         }
        for (int i = 0; i < peopleCount - 1 ; i++) {
            computers[i] = new Computer();
        }

         System.out.println("请输入玩家姓名");
         Scanner sc = new Scanner(System.in);
         String playerName = sc.nextLine();
         A = new Player(playerName);

    }
    public void startGame(int playCount){
        String playerChoose;
        System.out.println("请出拳\n1.剪刀。\n2.石头。\n3.布。");
        while(true) {
            Scanner player = new Scanner(System.in);
            playerChoose = player.nextLine();
            if (playerChoose.equals("1") || playerChoose.equals("2") || playerChoose.equals("3"))
                break;
            else{
                System.out.println("输入不合法，请重新输入");
            }
        }
        A.playerFingerGuess(playerChoose,playCount);
        for (int i = 0; i < peopleCount-1; i++) {
            computers[i].computerFingerGuess(playCount);
        }
    }
   public void judgeGame(int peopleCount){


   }

}