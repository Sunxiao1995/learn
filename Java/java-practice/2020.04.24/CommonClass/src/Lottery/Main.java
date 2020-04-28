package Lottery; 
import java.util.Scanner;



public class Main{
	public static void main(String[] args) {
		System.out.println("请输入任意值抽签，输入0退出：");
        String i = "";
		while(!(i.equals("0"))){
		Scanner sc = new Scanner(System.in);  
		i = sc.nextLine(); 
		String str = new String();
		
		str = Lottery.chooseSlips();
        System.out.println(str);
		}
	}
}