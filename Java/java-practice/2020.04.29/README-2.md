### 编程练习
使用java类描述一个学生类和其子类(小学生类、 中学生类， 高中生类)。
* 学生都具备名字成员和对应的get和set方法，get和set方法不能够被子类重写。
学生具备一个传入String名字的构造方法。
* 都具备学习的方法。调用学习的方法
* 编写一个main方法测试编写的类，依次创建小学生、中学生、高中生对象，分别调用学习的方法。


### 以下程序的输出结果是

#### 1.
```
class Clidder  
{ 
    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
        new Clidlet().flipper(); 
    } 
} 
```

Clidlet");  方法名一样，构成方法的重写

#### 2.

```
class Alpha  
{ 
    static String s = " "; 
    protected Alpha()  
    { 
        s += "alpha "; 
    } 
} 
class SubAlpha extends Alpha  
{ 
    private SubAlpha()  
    { 
        s += "sub "; 
    } 
} 
  
public class SubSubAlpha extends Alpha  
{ 
    private SubSubAlpha()  
    { 
        s += "subsub "; 
    } 
    public static void main(String[] args)  
    { 
        new SubSubAlpha(); 
        System.out.println(s); 
    } 
} 
```
子类不继承父类的构造方法，但是可以重写或者重载，在new子类对象是，会先调用父类的构造器 初始化父类的属性

alpha subsub 

#### 3.

```
class Grandparent  
{ 
    public void Print()  
    { 
        System.out.println("Grandparent's Print()");  
    }  
} 
  
class Parent extends Grandparent  
{ 
    public void Print()  
    { 
        System.out.println("Parent's Print()");  
    }  
} 
  
class Child extends Parent  
{ 
    public void Print()    
    { 
        super.super.Print();  //会报错.只能调用父类的方法
        System.out.println("Child's Print()");  
    }  
} 
  
public class Main  
{ 
    public static void main(String[] args)  
    { 
        Child c = new Child(); 
        c.Print();  
    } 
} 
```
#### 4.
```
final class Complex {
 
    private final double re;
    private final double im;
 
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
 
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
 
class Main {
  public static void main(String args[])
  {
       Complex c = new Complex(10, 15);
       System.out.println("Complex number is " + c);
  }         
}
```
#### 5.
```
class A
{
    String s = "Class A";
}
 
class B extends A
{
    String s = "Class B";
 
    {
        System.out.println(super.s);
    }
}
 
class C extends B
{
    String s = "Class C";
 
    {
        System.out.println(super.s);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
 
        System.out.println(c.s);
    }
}
```
new一个c时，会先给c的属性开辟空间，在构造时前 会给b的属性开辟空间 在构造前 会给a 的属性开辟空间，此时a的属性会被赋值，a构造完毕，转至b，b构造时打印a 转至c c 构造时打印b 最后打印c

#### 6.

```
class A
{
    static
    {
        System.out.println("THIRD");
    }
}
 
class B extends A
{
    static
    {
        System.out.println("SECOND");
    }
}
 
class C extends B
{
    static
    {
        System.out.println("FIRST");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
THIRD
SECOND
FIRST
```
#### 7.
```
class X
{
    static void staticMethod()
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{
    static void staticMethod()
    {
        System.out.println("Class Y");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y.staticMethod();
    }
}
直接通过类名调用 两个方法都已经加载了
```
#### 8.

```
class M
{
    static
    {
        System.out.println('A');
    }
 
    {
        System.out.println('B');
    }
 
    public M()
    {
        System.out.println('C');
    }
}
 
class N extends M
{
    static
    {
        System.out.println('D');
    }
 
    {
        System.out.println('E');
    }
 
    public N()
    {
        System.out.println('F');
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N();
    }
}
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
执行顺序 
a d b c e f
```
#### 9.

```
class A
{
	static String s = "AAA";

	static
	{
		s = s + "BBB";
	}

	{
		s = "AAABBB";
	}
}

class B extends A
{
	static
	{
		s = s + "BBBAAA";
	}

	{
		System.out.println(s);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();
	}
}
在构造b 时 会先执行父类的构造器 a 的值变为了a a a b b b
```
#### 10.
```
class X
{
	int i = 101010;

	public X()
	{
		i = i++ + i-- - i;  //运算完成后是101011
	}

	static int staticMethod(int i)
	{
		return --i;
	}
}

class Y extends X
{
	public Y()
	{
		System.out.println(staticMethod(i)); //调用静态方法
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
#### 11.
```
class ClassOne
{
     static int i, j = 191919;
 
     {
         --i;
     }
 
     {
         j++;
     }
}
 
public class ClassTwo extends ClassOne
{
    static
    {
        i++;
    }
 
    static
    {
        --j;
    }
 
    public static void main(String[] args)
    {
        System.out.println(i);
 
        System.out.println(j);
    }
}
1。19198。没有new
```
#### 12.
```
class A
{
	int[] a = new int[5];

	{
		a[0] = 10;
	}
}

public class MainClass extends A
{
	{
		a = new int[5];
	}

	{
		System.out.println(a[0]);
	}

	public static void main(String[] args)
	{
		MainClass main = new MainClass();
	}
}
0 构造方法重写 打印的是新new的值
```
#### 13.
```
class A
{
	static int i;

	static
	{
		i++;
	}

	{
		++i;
	}
}

class B extends A
{
	static
	{
		--i;
	}

	{
		i--;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		System.out.println(new B().i);
	}
}
0 都执行了一次
```
#### 14.
```
public class MainClass
{
	public MainClass(int i, int j)
	{
		System.out.println(method(i, j));
	}
	
	int method(int i, int j)
	{
		return i++ + ++j;
	}
	
	public static void main(String[] args) 
	{
		MainClass main = new MainClass(10, 20);
	}
}
31
```
#### 15.
```
class X
{
	static
	{
		Y.methodOfY();
	}
}

class Y extends X
{
	static void methodOfY()
	{
		System.out.println("Hi....");
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y.methodOfY();
	}
}
Hi....
Hi....
```
#### 16.
```s
class ClassOne
{
	static int i = 111;
	
	int j = 222;
	
	{
		i = i++ - ++j;
	}
}

class ClassTwo extends ClassOne
{
	{
		j = i-- + --j;
	}
}
```
