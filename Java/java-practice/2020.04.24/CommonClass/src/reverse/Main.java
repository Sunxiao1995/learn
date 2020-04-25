package Reverse;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		//String a = input.next();

        String a = "To be or not to be";
		char[] chars = Reverse.reverseWords(a);
		String str = String.valueOf(chars);
		System.out.println(str);
	}
}