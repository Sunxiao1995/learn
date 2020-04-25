package StringBuffer;

public class Main{
	public static void main(String[] args) {
		StringBuffer.append("acdefgh");
		StringBuffer.append('i');
		System.out.println(StringBuffer.string);
		System.out.println(StringBuffer.reverse());
		System.out.println(StringBuffer.reverse(2,4));
		StringBuffer.clear();
		System.out.println(StringBuffer.string);

	}
}