package club.banyuan;

public class Person{
	  static private String name;
	  static private int age;
	
    public Person(){
    	this.name = "未设置";
		this.age = 1;
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

//无参数的可以调用有参数的构造方法
