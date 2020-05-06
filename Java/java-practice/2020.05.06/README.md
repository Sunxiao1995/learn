### 以下程序的输出结果是
#### 1.
```
class Base {
    final public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}

编译报错，因为final 修饰的方法不能被重写
```

#### 2.
```
class Base {
    public static void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public static void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
静态的方法不构成重写 在调用时不会去调用子类中重写的方法
```

#### 3.
```
class Base {
    public void Print() {
        System.out.println("Base");
    }         
}
 
class Derived extends Base {    
    public void Print() {
        System.out.println("Derived");
    }
}
 
class Main{
    public static void DoPrint( Base o ) {
        o.Print();   
    }
    public static void main(String[] args) {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z); // 掉用函数时会转换成为父类
    }
}

Base
Derived
Derived

```

#### 4.

```
class Base {
    public void foo() { System.out.println("Base"); }
}
  
class Derived extends Base {
    private void foo() { System.out.println("Derived"); } 
}
  
public class Main {
    public static void main(String args[]) {
        Base b = new Derived();
        b.foo();
    }
} 
编译报错 私有化不构成重写但是出现了重名的方法
```

#### 5.
```

public class NewClass { 
	public static class superclass { 
		static void print() 
		{ 
			System.out.println("print in superclass."); 
		} 
	} 
	public static class subclass extends superclass { 
		static void print() 
		{ 
			System.out.println("print in subclass."); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		superclass A = new superclass(); 
		superclass B = new subclass(); 
		A.print(); 
		B.print(); 
	} 
} 
创建的两个对象都是父类对象，由于是静态方法，在子类中定义相同的方法名，相当于子类中父类区域的相同方法被隐藏了，只能通过调用子类的方式来调用
静态类的继承问题？？

```
#### 6.
```

public class NewClass { 
	public static class superclass { 
		void print() 
		{ 
			System.out.println("print in superclass."); 
		} 
	} 

	public static class subclass extends superclass { 
		@Override
		void print() 
		{ 
			System.out.println("print in subclass."); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		superclass A = new superclass(); 
		superclass B = new subclass(); 
		A.print(); 
		B.print(); 
	} 
} 
方法的重写
print in superclass
print in subclass
```

#### 7.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getData(); 
    } 
} 
Inside ClassTwo
方法的重写
```

#### 8.
```
class Test 
{ 
    void myMethod() 
    { 
        System.out.println("Test");
    } 
} 
class Derived extends Test
{ 
    void myMethod() 
    { 
        System.out.println("Derived");
    } 
      
    public static void main(String[] args) 
    { 
        Derived object = new Test(); 
        object.myMethod(); 
    } 
} 
编译报错 子类对象不能引用父类对象
```
#### 9.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
      
    protected void getValue() 
    { 
        System.out.println("ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getValue(); 
    } 
}
在父类对象引用子类对象是 使用父类对象名只能调用父类里有的属性和方法 然后在看改方法有没有被子类重写，如果有，调用的是子类重写的方法
```