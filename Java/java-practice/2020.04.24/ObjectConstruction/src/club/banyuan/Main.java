package club.banyuan;

   public class Main{
	public static void main(String[] args) {
	Person person = new Person();
	Person.speak();
    Person zhangsan = new Person("张三", 18);
    Person.speak();
    Person lisi = new Person("李四")	;
    Person.speak();
	}
	
}