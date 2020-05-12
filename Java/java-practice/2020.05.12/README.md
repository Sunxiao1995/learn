### 写出以下程序的输出结果

#### 1. 以下代码能否通过编译，为什么
```
class Outer{
 public static void main(String[] args){
  new Inner(); 
 } 
 class Inner { 
  Inner() {} 
 }  
}
```
不可以，在new内部类的时候 要有外部内的对象 使用外部内的对象才能new内部类

#### 2. 以下代码能否通过编译，为什么

```
static class Outer{
 public static void main(String[] args){
 //
 }
 private class Inner{
  Inner() {} 
 }
}
```

不可以 外部类不能使静态的

#### 3.

```
class Outer {
 String s1 = "Java";
 String s2 = "2";

 public static void main(String[] args) { 
  Outer outer = new Outer();  
 }
 Outer() { 
  Inner inner = new Inner();  
 }
 class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
        
  Inner() {
   System.out.println(Outer.this.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}

Java 
Certification
Exam
外部类.this 引用外部类对象的成员或方法
```
#### 4. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        static void methodB()
        {
            System.out.println("Method B");
        }
    }
}

不能，非静态内部类不能有静态的成员或者方法
```
#### 5.
```
class OuterInnerStatic {
 static String s1 = "Java"; 
 static String s2 = "2";
 public static void main(String[] args) { 
  Inner inner = new Inner();  
}

 static class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
  Inner() {
   System.out.println(OuterInnerStatic.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}
Java 
Certification
Exam
在静态内部类中 可以直接调用外部内的静态成员或方法 如果有重名的 外部类的静态成员可以直接通过类名的方式进行调用
```
#### 6.
```
class X
{
    static int x = 3131;
     
    static class Y
    {
        static int y = x++;
         
        static class Z
        {
            static int z = y++;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(X.x);
         
        System.out.println(X.Y.y);
         
        System.out.println(X.Y.Z.z);
    }
}
3131
3131
3131
在静态内部类中 可以直接调用外部内的静态成员或方法 如果有重名的 外部类的静态成员可以直接通过类名的方式进行调用
```

#### 7. 在下面的示例中，如何访问"XYZ"类的"i"字段？
```
class ABC
{
    class XYZ
    {
        int i = 111;
    }
}

在外部类中new一个内部类，使用对象.的方式来访问内部内的属性
```

#### 8. 运行以下程序时，它是否在控制台上打印“SUCCESS”？
```
class A
{
    {
        new B();
    }
     
    static class B
    {
        {
            new A().new C();
        }
    }
     
    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
会反复的new A 和 new B 直到堆栈溢出
```

#### 9. 以下代码能否通过编译，为什么
```
class A
{
    String s = "AAA";
     
    void methodA()
    {
        System.out.println(s);
    }
     
    static class B
    {
        void methodB()
        {
            methodA();
        }
    }
}
不能，静态内部类可以通过new 外部类.内部类的方式创建出来 此时调用方法B的时候 外部类还没有创造对象 无法使用方法A;
```

#### 10.
```
abstract class A
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };
    }
}
new的时候加载的顺序和普通类差不多 加大括号相当与匿名类 不然无法new出来
```
#### 11.
```
class A
{
    static String s = "AAA";
     
    class B
    {
        String s = "BBB";
         
        void methodB()
        {
            System.out.println(s);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        System.out.println(a.s);
         
        A.B b = a.new B();
         
        System.out.println(b.s);
         
        b.methodB();
    }
}
AAA
BBB
BBB
在内部类中调用外部类中与内部类重名的属性可以用外部类.this.的方式来调用。
```

#### 12. 以下代码能否通过编译，为什么
```
class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
        // B b = new B();
        //b.methodTwo();
    }
     
    void methodThree()
    {
        new B().methodTwo();
        //A a = new A();
        //a.methodOne();
    }
}
在方法中定义的非静态内部类，必须在方法中就被实例化 调用该内部类的属性或者方法 
```

#### 13
```
class X
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
     
    public X()
    {
        new Y();
    }
     
    static class Y
    {
        {
            System.out.println(3);
        }
         
        static
        {
            System.out.println(4);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();
         
        X.Y y = new X.Y();
    }
}
与父子类的差别 先构造外部类 在会去new一个内部类 注意static代码块只会被加载一次
```

#### 14. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        {
            System.out.println(1);
        }
         
        static
        {
            System.out.println(2);
        }
    }
}
编译错误 非静态内部类中不能出现静态的代码块 方法 属性
```

#### 15.
```
class ABC
{
    int i = 10101;
     
    {
        i--;
    }
     
    public ABC()
    {
        --i;
    }
     
    class XYZ
    {
        int i = this.i;
         
        {
            i++;
        }
         
        public XYZ() 
        {
            ++i;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        ABC abc = new ABC();
         
        System.out.println(abc.i);
         
        ABC.XYZ xyz = abc.new XYZ();
         
        System.out.println(xyz.i);
         
        ABC.XYZ xyz1 = new ABC().new XYZ();
         
        System.out.println(xyz1.i);
    }
}

10099
2
2
this.i 前面只有加上外部类名才能调用重名的属性
```
#### 16.
```
class P
{
    String s = "PPP";
     
    {
        System.out.println(s);
    }
     
    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";
             
            {
                System.out.println(s);
            }
        }
         
        return new Q().s+s;   //new的时候打印PPPQQQ
                              //此时加的s是P里的s
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        P p = new P();  //这个时候打印PPP
         
        System.out.println(p.methodP());
    }
}
PPP
PPPQQQ
PPPQQQPPP

```

#### 17. 

```
class A
{
    void methodA1(int i)
    {
        System.out.println(i+++i);
    }
     
    void methodA2(int i)
    {
        System.out.println(--i-i--);
    }
}
 
class B
{
    A a = new A()
    {
        void methodA1(int i)
        {
            System.out.println(++i+i++);
        }
         
        void methodA2(int i)
        {
            System.out.println(i---i);
        }
    };
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        a.methodA1(10);
         
        a.methodA2(10);
         
        B b = new B();
         
        b.a.methodA1(10);
         
        b.a.methodA2(10);
    }
}
匿名类重写了方法
21
0
22
1
```

#### 18. 以下代码能否通过编译，为什么
```
class One
{
    void methodOne()
    {
        public class Two
        {
             
        }
    }
}
内部类只能被protected private static 修饰 或者不写
```


#### 19.

```
class One
{
    {
        System.out.println("ONE");
    }
     
    class Two
    {
        {
            System.out.println("TWO");
        }
    }
     
    static
    {
        System.out.println("THREE");
    }
     
    static class Three
    {
        {
            System.out.println("FOUR");
        }
         
        static
        {
            System.out.println("FIVE");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        One one = new One();
         
        One.Two two = one.new Two();
         
        One.Three three = new One.Three();
    }
}
静态内部类里的静态代码块也只有在new的时候才会被加载
```

#### 20. 以下代码能否通过编译，为什么
```
class A
{
    class B extends A
    {
        class C extends B
        {
            class D extends C
            {
                 
            }
        }
    }
}
可以，允许内部类继承外部类
```

#### 21.
```
abstract class X
{
    static String s1 = "STATIC";
     
    String s2 = "NON-STATIC";
     
    abstract void methodX(); 
     
    static abstract class Y
    {
        String s1 = "NON-STATIC";
         
        static String s2 = "STATIC";
         
        abstract void methodY();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X() 
        {   
            void methodX()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();
         
        new X.Y() 
        {   
            void methodY() 
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();
    }
}

STATIC NON-STATIC
NON-STATIC STATIC
匿名内重写方法
```

#### 22. 在下面的示例中，如何访问“内部类”的“i”字段？
```
class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}
如果是在内部类里 方法可以直接调用 如果是在外部类 需要在外部内中new一个内部类的对象 通过对象.i的方式来引用。如果是在外部 就需要先new一个外部类 在通过OuterClass.InnerClass xx = x.new InnerClass() new一个内部类对象 在通过对象的方式来引用
```

#### 23.
```
class X
{   
    static
    {
        class Y
        {   
            {
                System.out.println(1);
            }
        }
    }
     
    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
不会报错但是也不会有输出 可以早代码块里new一个 这样就在在构造外部内的同时构造内部类
```

#### 24.
```
class A
{   
    abstract class B
    {
        abstract void method();
    }
     
    {
        new B()
        {
             
            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}

代码块里匿名类重写方法
BBB
```

#### 25.
```
class X
{   
    void methodX()
    {
        class Y
        {
            static void methodY()
            {
                 
            }
        }
    }
}
非静态类中不能出现静态成员或者方法
```

#### 26. 如何在class A以外的其他类中实例化 class B
```
class A
{
    void methodA()
    {
        class B
        {
             
        }
    }
}
在methodA()中实例化B 这样外部的其他类中可以先实例化外部内 在调用外部类的methodA()方法 即可以实例化B
```

#### 27.
```
public class Outer 
{ 
	public static int temp1 = 1; 
	private static int temp2 = 2; 
	public int temp3 = 3; 
	private int temp4 = 4; 
	
	public static class Inner 
	{ 
		private static int temp5 = 5; 
		
		private static int getSum() 
		{ 
			return (temp1 + temp2 + temp3 + temp4 + temp5); 
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		Outer.Inner obj = new Outer.Inner(); 
		System.out.println(obj.getSum()); 
	} 
	
} 
编译报错 静态方法中引用了非静态成员变量
```

#### 28.
```
public class Outer  
{ 
    private static int data = 10; 
    private static int LocalClass() 
    { 
        class Inner 
        { 
            public int data = 20; 
            private int getData() 
            { 
                return data; 
            } 
        }; 
        Inner inner = new Inner(); 
        return inner.getData(); 
    } 
      
    public static void main(String[] args) 
    { 
        System.out.println(data * LocalClass()); 
    } 
}

200
静态方法里定义一个内部类 返回值为20
```

#### 29.
```
interface Anonymous 
{ 
	public int getValue(); 
} 
public class Outer 
{ 
	private int data = 15; 
	public static void main(String[] args) 
	{ 
		Anonymous inner = new Anonymous() 
				{ 
					int data = 5; 
					public int getValue() 
					{ 
						return data; 
					} 
					public int getData() 
					{ 
						return data; 
					} 
				}; 
		Outer outer = new Outer(); 
		System.out.println(inner.getValue() + inner.getData() + outer.data); 
	} 
} 
接口中没有定义getData 方法，无法调用
```

#### 30.
```
public class Outer 
{ 
    private int data = 10; 
      
    class Inner 
    { 
        private int data = 20; 
        private int getData() 
        { 
            return data; 
        } 
        public void main(String[] args) 
        { 
            Inner inner = new Inner(); 
            System.out.println(inner.getData()); 
              
        } 
    } 
    private int getData() 
    { 
        return data; 
    } 
    public static void main(String[] args) 
    { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        System.out.printf("%d", outer.getData()); 
        inner.main(args); 
    } 
} 

1020
```

#### 31.
```
interface OuterInterface 
{ 
    public void InnerMethod(); 
    public interface InnerInterface 
    { 
        public void InnerMethod(); 
    } 
} 
public class Outer implements OuterInterface.InnerInterface, OuterInterface 
{ 
    public void InnerMethod() 
    { 
        System.out.println(100); 
    } 
      
      
    public static void main(String[] args) 
    { 
        Outer obj = new Outer(); 
        obj.InnerMethod(); 
    } 
} 

100 调用重写的方法
```
