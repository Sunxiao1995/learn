package club.banyuan;

import java.util.Scanner;

public class Menu {
	private static final int COUNT = 40;                 //如果猜的次数设置的过大，数组就要加大
	private static int[] guessNumber = new int[COUNT];   //用来保存过程中猜的数字
	private static int inputGuessTime;                  //用来保存过程中猜的次数
	private static int residueNumber ;                  //用来保存猜数字剩余的次数
	private static int needGuessNumber;                 //用来保存需要被猜的数

	public static void mainMenu() {
		System.out.println("请选择难度等级\n1. 0~9 \n2. 0~99 \n3. 0~999\n0. 退出");
	}

	public static String countChangeLevel(String str) {
		if (str.equals("1"))
			return "0~9";
		else if (str.equals("2"))
			return "0~99";
		else
		return "0~999";
	}

	public static void chooseLevelMenu(String input) {

		switch (input) {
			case ("1"):

			case ("2"):

			case ("3"):
				System.out.println("你当前选择的难度等级为" + countChangeLevel(input));
				System.out.println("请输入想要猜的次数，0返回上一级");
				System.out.print("你的输入:");
				Scanner sc = new Scanner(System.in);
				inputGuessTime = sc.nextInt();
				if (inputGuessTime == 0)
					break;
				else
					startGuessNumber(inputGuessTime, input);
				break;
		}
	}

	//
	public static void startGuessNumber(int i, String level) {
		System.out.println("\n现在开始猜数");
		System.out.print("剩余次数是" + i + ",请输入数字(" + countChangeLevel(level) + ") : ");
		residueNumber = i;
		if (level.equals("1")) {
			needGuessNumber = Level.getLevelLowCount();
		} else if (level.equals("2")) {
			needGuessNumber = Level.getLevelMiddleCount();
		} else {
			needGuessNumber = Level.getLevelHighCount();
		}

		for (int j = 0; j < i; j++) {
			Scanner sc = new Scanner(System.in);
			guessNumber[j] = sc.nextInt();
			System.out.print("输入的是" + guessNumber[j]);
			residueNumber--;

			if (guessNumber[j] == needGuessNumber) {
				System.out.println("，恭喜你，猜中了");
				break;
			} else if (guessNumber[j] > needGuessNumber) {
				System.out.println("，没有猜中，猜大了");
				if (residueNumber == 0){
					System.out.print("剩余次数为0");
					break;
				}
				System.out.print("\n剩余次数"+residueNumber+"，请输入数字：");
				continue;
			} else {
				System.out.println("，没有猜中，猜小了");
				if (residueNumber == 0){
					System.out.print("剩余次数为0");
					break;
				}
				System.out.print("\n剩余次数"+residueNumber+"，请输入数字：");
				continue;
			}
		}


	}

	public static boolean gameGoonOrNot() {
		System.out.println("\n\n是否继续， 1.继续, 0.退出");
		Scanner sc = new Scanner(System.in);
		int gameGoonOrNot = sc.nextInt();
		if (gameGoonOrNot == 1) {
			return true;
		}
		else
			gameLoad();
		return false;
	}

	public static void gameLoad() {
		System.out.println("\n猜题记录");
		System.out.println();
		for (int i = 0; i < inputGuessTime-residueNumber; i++) {
			if(guessNumber[i] == needGuessNumber){
				System.out.println("第"+(i+1)+"次"+" "+guessNumber[i]+" => 正确");
			    break;}
			else{
				System.out.println("第"+(i+1)+"次"+" "+guessNumber[i]+" => "+(guessNumber[i]-needGuessNumber));
			}

		}
	}

	public static void playGames() {
		while (true) {
			mainMenu();
			Scanner sc = new Scanner(System.in);
			String level = sc.nextLine();
			if (level.equals("0"))
				break;
			else
				chooseLevelMenu(level);
			if (inputGuessTime == 0)
				continue;
			else
				if(gameGoonOrNot())
					continue;
				else {
					break;
				}
		}
	}

}