## lambda 表达式

### 前提：匿名内部类

在类的内部 只创建类的一个对象，以便使用其中的方法，这种类被称为匿名内部类

```
{
	ActionListener listener = new ActionListenerO
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("At the tone, the time is " + new DateO)；
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}；
	Timer t = new Timer(interval, listener);
	t.start()；
}
```

以上的含义是：创建了一个实现ActionLIstener接口的类的匿名对象 需要实现的方法定义在括号内 ActionListener 可以是接口也可以是类 匿名类内部没有构造器。

### 1、lambda表达式语法

假设我们有一个大象的类 需要比较大象对象的高度

```
public class Elephant{
   private int height;
   
   Elephant(int height){
   
        this height = height;
   }
   
   public int getHeight(){
       return height;
   }
}
```

以上是一个大象的类 如果我们需要比较大象对象的高度，需要创建大象的对象 得到大象对象的高度 对其进行比较操作 我们可以定义一个类 这个类提供一个方法 参数为两个大象的对象 返回值为高度的差值  同样的，java提供许多接口 Comparator\<T> 此泛型接口内部有一个抽象方法compare可以满足我们的需求 所以我们可以使用匿名内部类的方式来调用此方法

```
public class Main{
      public static void main(String[] args) {
         Elephant a = new Elephant(10);
         Elephant b = new Elephant(20);
         
         Comparator<Elephant> c = new Comparator<>(){
          @Override
         public int compare(Elephant a, Elephant b) {
            return a.getHeight() - b.getHeight();
          }
      }
      c.compare(a , b);
      
  }
  
```

以上就是使用内部类传递方法的使用方法

在此引入**函数式接口**的概念

- **函数式接口**

函数式接口是接口内部只定义一个抽象方法的接口，这样的接口在可以使用lambda表达式来表示这样一个接口对象。

接口内部有静态方法 默认方法 以及object 里原有的方法 不影响队函数式接口的判断



- **lambda表达式语法**

lambda使用 `->` 连接参数和方法体。通常有以下几种定义方式

```
( ) -> {
    语句
    return 返回值;
};
(数据类型 参数1,数据类型 参数2 ) -> {
    语句
    return 返回值;
};
// 省略参数类型
(参数1,参数2 ) -> {
    语句
    return 返回值;
};
// 只有一个参数的时候，省略括号
参数 -> {
    语句
    return 返回值;
};
// 如果只有一句话，可以省略大括号, return 关键字也可以省略。
参数 -> 语句;

```

以上的代码可以写成lambda表达式

```
 Comparator<Elephant> c = (a1,b1) -> a1.getHeight - a2.getHeight;
```



### 2、lambda表达式与匿名内部类

lanbda 表达式只能表示没有成员变量的匿名内部类



### 3、变量捕获

lambda表达式能够访问在lambda方法体外部声明的变量。被称作变量捕获

Java lambda可以捕获以下类型的变量：

- 局部变量
- 实例变量
- 静态变量

#### 3.1 局部变量捕获

lambda可以捕获在lambda主体外部声明的局部变量的值 但是此局部变量必须是final的 在后面不会对其值进行改变 。即使在lambda表达式内部也不行。



#### 3.2 成员变量捕获

在lambda内部使用this表示定义了lambda表达式的对象的成员变量 当这个值改变的时候 在lambda表达式内部也会改变 反之亦然 this不能用在静态方法里



#### 3.3 静态变量捕获

与成员变量类似



### 4、Lambda的方法引用

如果lambda表达式中调用了另一个方法，可以简写

```
public interface MyPrinter{
    public void print(String s);
}
```

创建lambda实例：

```
MyPrinter myPrinter = (s) -> { System.out.println(s); };
```

单条语句单个参数可以简写成以下的样子

```
MyPrinter myPrinter = s ->  System.out.println(s);
```

由于lambda主体所做的一切都是将字符串参数转发给System.out.println()方法，因此我们可以将上述lambda声明替换为方法引用。以下是lambda方法参考的外观：

```
MyPrinter myPrinter = System.out::println;
```

**理解：**在函数式接口中 可以用lambda表达式表示其中的函数  当函数里调用其他方法 且这个方法的参数和表达式相同时 就可以使用简写

#### 4.1 引用静态方法

参数相同即可，冒号前面用冒号代替

#### 4.2 引用参数方法

冒号前面的是参数类型 后面是参数的方法

注意此参数方法所需调用的参数个数要与函数式接口里的参数一致

#### 4.3 引用实例方法

与静态方法差不多 只是在引用之前要先new一个对象出来，在用对象名引用

#### 4.4 构造方法引用

可以引用一个类的构造方法  该构造方法的参数和函数式接口的方法参数相同即可



### 5、加入泛型





### 6、流 stream

Stream（流）是一个来自数据源的元素队列并支持聚合操作。

- **数据源** 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。

(也就是这些来源可以点出来stream())

- **聚合操作** 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。和以前的Collection操作不同， Stream操作还有两个基础的特征：

- **内部迭代**： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

**forEach**

```
Iterable 接口中的一个实例方法 所有继承自该接口的接口的实现类都有该方法

源码
 default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
    
this 是指谁调的这个方法 指的就是谁
该方法表示 在consumer内部的accept 方法 遍历 调这个方法的 实现accept accept 在实现的时候被重写

Comsumer<T> 函数式接口 接收一个T 的对象 没有返回值

Stream 里也定义了一个forEach方法
和上面的功能相似
```

**map**

```
 <R> Stream<R> map(Function<? super T, ? extends R> mapper)
 
 接收一个T 返回一个R的流、映射
 public interface Function<T, R> {
    R apply(T t);
 }
 
 
```

 **filter**

```
Stream<T> filter(Predicate<? super T> predicate);

接收一个条件 返回被过滤的流
@FunctionalInterface
public interface Predicate<T> {
       boolean test(T t);
 }
```

 **limit**

```
Stream<T> limit(long maxSize);

接收一个数值 返回该数值的流 
```

 **sorted**

sorted() 默认使用自然序排序， 其中的元素必须实现Comparable 接口

sorted(Comparator comparator) ：我们可以使用lambada 来创建一个Comparator 实例。可以按照升序或着降序来排序元素。

```
Stream<T> sorted(Comparator<? super T> comparator)
返回一个排序好的流 如果需要反序则使用compare的reserved方法(实现了comparable的使用reserveorder)

@FunctionalInterface
public interface Comparator<T> {
     int compare(T o1, T o2);
 }    
```

**collect**

转成set List  等操作(很多用法)

https://www.jianshu.com/p/ccbb42ad9551

```
List<Sighting> collect = sightings.stream()
    .filter(abc -> abc.getAnimal().equals(sighting.getAnimal()))
    .collect(Collectors.toList());
```



