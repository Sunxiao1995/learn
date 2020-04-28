### 以下程序的输出结果是
要加上注释说明程序运行结果的原因。题目先自己想答案，然后运行代码查看结果和自己想的是否一致，然后记录注释
#### 例. 
```
class A 
{ 
	public A(String s) 
	{ 
		System.out.print("A"); 
	} 
} 

public class B extends A 
{ 
    // 编译报错，因为类A中没有无参构造方法，子类构造方法中没有显式调用父类的构造方法
	public B(String s) 
	{ 
		System.out.print("B"); 
	} 
	public static void main(String[] args) 
	{ 
		new B("C"); 
		System.out.println(" "); 
	} 
} 
```

#### 1. 

```
class Base {
    public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
public class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
```

#### 2.
```
class A
{
    int i = 10;
}
 
class B extends A
{
    int i = 20;
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new B();
 
        System.out.println(a.i);
    }
}
```

#### 3.
```
class A
{
    {
        System.out.println(1);
    }
}
 
class B extends A
{
    {
        System.out.println(2);
    }
}
 
class C extends B
{
    {
        System.out.println(3);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
```

输出结果为1

2

3

代码块的内容会默认的放在构造器中执行

因为在创建自类对象的时候，不写会默认使用父类的无参构造器创建父类对象的构造区

#### 4.

```
class A
{
    public A()
    {
        System.out.println("Class A Constructor");
    }
}
 
class B extends A
{
    public B()
    {
        System.out.println("Class B Constructor");
    }
}
 
class C extends B
{
    public C()
    {
        System.out.println("Class C Constructor");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
```

因为在创建子类对象的时候，不写会默认使用父类的无参构造器创建父类对象的构造区

#### 5. 

```
class X
{
    public X(int i)
    {
        System.out.println(1);
    }
}
 
class Y extends X
{
    public Y()  // 编译报错，因为在子类的构造未写，会默认调用其父类的无参数构造器，而当父类有仅一个有参数的构造器时，编译时不会给其加上无参数的构造器；
    {
        System.out.println(2);
    }
}
```


#### 6. 

```
public class A  //所有的类都继承一个超类 ，所以可以直接用super
{
    public A()
    {
        System.out.println(1);
 
        super();   //编译报错 因为super要在第一句
 
        System.out.println(2);
    }
}
```
#### 7. 
```
public class A
{
    public A(int i)
    {
 
    }
}
 
class B extends A
{
              //编译报错，不写表示使用无参数的构造方法，而父类中没有无参数的构造方法
}
```
#### 8. 
```
public class A
{
    public A()
    {
        super();   //编译报错 super 和 this 都要求写在第一句
 
        this(10);
    }
 
    public A(int i)
    {
        System.out.println(i);
    }
}
```

#### 9. 

```
class M
{
    int i;   //27 赋值后在自减
 
    public M(int i)
    {
        this.i = i--;
    }
}
 
class N extends M
{
    public N(int i)
    {
        super(++i);  //自增后在调用父类有参数构造器
 
        System.out.println(i);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
    }
}
```
输出的值为27

#### 10. 

```
class M
{
    int i = 51;
 
    public M(int j)
    {
        System.out.println(i);   
 
        this.i = j * 10;
    }
}
 
class N extends M
{
    public N(int j)
    {
        super(j);
 
        System.out.println(i);
 
        this.i = j * 20;
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
 
        System.out.println(n.i);
    }
}
```
51。260。520



#### 11. 

```
class X
{
    private int m = 48;
}
 
class Y extends X
{
    void methodOfY()
    {
        System.out.println(m);  //同包的类 private 无法继承
    }
}
```
报错

#### 12. 

```
class X
{
    int m = 1111;
 
    {
        m = m++;   //赋值的时候m还没加
 
        System.out.println(m);
    }
}
 
class Y extends X
{
    {
        System.out.println(methodOfY());
    }
 
    int methodOfY()
    {
        return m-- + --m;  //m先执行自减 在相加 过程后m还会在减1
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y y = new Y();
    }
}
```

#### 13. 
```
class A
{
	void A()
	{
		System.out.println(1);
	}
}

class B extends A
{
	void B()
	{
		A();
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		new B().B();
	}
}
```
void 开头的是类里的一个方法，不是构造器，生成一个对象以后调用b方法会去调用a方法



#### 14. 

```
class A
{
	int i = 1212;
}

class B extends A
{
	A a;

	public B(A a)
	{
		this.a = a;  new出来的对象a也是对象b里
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		A a = new A();

		B b = new B(a);

		System.out.println(a.i);

		System.out.println(b.i);

		System.out.println(b.a.i);

		b.a.i = 2121;

		System.out.println("--------");

		System.out.println(a.i);

		System.out.println(b.i);
	}
}

1212
1212
1212
--------
2121
1212
```

#### 15. 

```
class A
{
	int methodOfA(int i)
	{
		i /= 10;

		return i;
	}
}

class B extends A
{
	int methodOfB(int i)
	{
		i *= 20;

		return methodOfA(i);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();

		System.out.println(b.methodOfB(100));
	}
}  100 ==》2000 ==〉200
```

#### 16. 
```
class One
{
	int x = 2121;
}

class Two 
{
	int x = 1212;
	
	{
		System.out.println(x);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Two two = new Two();
	}
}
//无论Two是否继承One 都是1212 因为变量先加载
```

静态变量 
静态初始化块 
变量 
初始化块 
构造器 



父类--静态变量 
父类--静态初始化块 
子类--静态变量 
子类--静态初始化块 
父类--变量 
父类--初始化块 
父类--构造器 
子类--变量 
子类--初始化块 
子类--构造器 