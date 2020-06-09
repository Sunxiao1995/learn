package club.banyuan.RefineCode;


public class ReverseHelloMultithreaded {
    static int count = 50;

    static class HelloThread extends Thread{
        @Override
        public void run() {
            if(count >= 1){
                System.out.println("Hello from Thread"+ count);
                count--;
                Thread thread = new HelloThread();
                thread.start();
            }
        }
    }

    public static void doReverseHello() {
        Thread thread = new HelloThread();
        thread.start();
    }
}
