
public class Person{
	 static private String name;
	 static private int age;
	
    public Person(){
    	this.name = "未设置";
		this.age = 0;
	}
    
    public Person(String name){
		this();
		this.name = name;
		
	}

	public Person(String name,int age){
		this(name);
        this.age = age;
	}


	   static void speak(){
		System.out.println("加入了一个人，姓名是"+name+",年龄是"+age);
	}
}

    class Main{
	public static void main(String[] args) {
	Person person = new Person();
	Person.speak();
    Person zhangsan = new Person("张三", 18);
    Person.speak();
    Person lisi = new Person("李四")	;
    Person.speak();
	}
	
}