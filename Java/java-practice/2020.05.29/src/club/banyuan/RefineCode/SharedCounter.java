package club.banyuan.RefineCode;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {
    static int counter = 0;
    static int classNumIncrementsPerThread;
    public static void reset() {
        counter = 0;
    }
    static List<Thread> list = new ArrayList<>();

    static class IncrementThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (SharedCounter.class) {//必须加锁，不然两个线程可能拿到的是同一个值
                //如果用lock,要在lock前加上static，因为每次Thread thread = new IncrementThread()时，不同的对象lock也不同
                counter += classNumIncrementsPerThread;
            }
        }
    }

    public static int increment(int numThreads, int numIncrementsPerThread) throws InterruptedException {
        classNumIncrementsPerThread = numIncrementsPerThread;
        for(int i = 0; i < numThreads; i++){
            Thread thread = new IncrementThread();
            list.add(thread);
            thread.start();
        }

        for(Thread one : list){
            one.join();
        }
        return counter;
    }
}
