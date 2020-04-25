package randomTest;
import java.util.Scanner;
public class Main{
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("请输入随机数的范围：");
	int a = in.nextInt();
	int b = in.nextInt();
	int random = randomTest.randomInt(a,b);
    System.out.println("生成的随机数是"+random);

}
}