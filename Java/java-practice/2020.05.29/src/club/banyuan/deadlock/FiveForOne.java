package club.banyuan.deadlock;

public class FiveForOne implements Runnable {

  @Override
  public void run() {
    // synchronized (TestThread.class) {

    synchronized (TestThread.lock5) {
      System.out.println("One For Two lock5");

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (TestThread.lock1) {
        System.out.println("One For Two lock1");
      }
    }

    // }
  }
}
