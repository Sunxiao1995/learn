## 课堂练习
### 计算机网络和因特网
8、在周末，Alice经常要通过她的笔记本电脑访问保存在办公室台式机上的文件。上周她在办公室台式机上安装了一个FTP服务器程序的副本，在家里的笔记本电脑上安装了FTP客户机程序的副本。她很失望周末无法访问到她的文件。这可能出现什么差错了?

答：FTP服务器未搭建好，两台计算机之间未建立有效连接(控制连接和数据连接）。

9、大多数安装在个人计算机上的操作系统带有几个客户端进程，但通常没有服务器进程，请解释原因。

答：客户端是为客户提供本地服务的程序。，服务器是指网络中能对其它机器提供某些服务的计算机系统，相对于个人计算机来说，不为他人提供服务，也就不作为服务器使用。

3、假设连接到因特网的主机在2010年是5亿台。这个数字以每年20%的速度增长，到2020年主机数量是多少?  

答：5*10<sup>8</sup> *(1+0.2)<sup>10</sup>=30 9586 8211台

9、比较16位端口地址(0〜65535)和32位IP地址(0〜4294967295)的范围，为什么我们需要IP地址有如此大的范围，但端口号却相对范围小呢?

答：IP地址可以标识唯一的一台计算机，而计算机增长的速度比较快，所以范围比较大。而在计算机中，不同的应用程序是通过端口号来区分的，相对于计算机来说，程序的数量没有那么多。所以端口号的范围较小。

**思考：www.baidu.com并回车到底发生了些什么？？**  
1、输入网址  
2、通过DNS解析，先检查自己的缓存有没有，有的话直接返回，没有的话在根据根域名、顶级域、域的服务器来找到IP地址  
3、根据IP地址找到对应的服务器  
4、使用HTTP协议，向该主机发送请求，表示我想要该URL对应的页面  
5、找到相对应的资源库（三次握手）  
6、百度的服务器并使用HTTP协议传输HTML文档给浏览器  
7、浏览器解析该HTML，并显示  


### 操作系统
9、为什么操作系统需要队列?  
为了处理多个进程和作业，进程管理器使用队列（等待列表）进程管理器可以用多种策略从队列中选择下一个作业或进程，因为CPU和内存等的大小是有限制的，不可能同时处理所有的作业或进程。  

10、死锁和饿死有何区别?
死锁是由以下几个条件产生：
- **互斥**。一个资源只能被一个进程占有；
- **资源占有**。一个进程占有一个资源，即使在获取其他资源之前无法使用它；
- **抢先**。操作系统不能临时对资源重新分配；
- **循环等待**。所有的进程和资源包含在一个循环里  

饿死是发生在在当操作系统对进程分配资源有太多限制的时候；假设当一个进程只有在所需的资源全部占有才能执行，这样会造成当这个程序执行的时候，其所需的资源有一部分正在被其他程序执行，无法在某一刻获取全部的资源。

9、三个进程(A、B和C)同时运行，进程A占用File1但需要File2。进程B占用File3但需要File1。进程C占用File2但需要File3。为这几个进程画一个框图。这种情况是不是死锁?
![](https://github.com/Sunxiao1995/learn/blob/master/photo/14.jpeg)  
是死锁  
10、三个进程(A、B和C)同时运行，进程A占有File1，进程B占有File2但需要File1,进程C占有File3但需要File2。为这几个进程画一个框图。这种情况是不是死锁?如果不是，说明进程怎样最后完成它们的任务。
![](https://github.com/Sunxiao1995/learn/blob/master/photo/15.jpeg)  
不是死锁，进程A完成后释放File1，此时进程B可以工作,进程B完成后释放File1和File2，C进程可以工作


