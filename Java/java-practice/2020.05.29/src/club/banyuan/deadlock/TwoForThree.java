package club.banyuan.deadlock;

public class TwoForThree implements Runnable {

  @Override
  public void run() {
    // synchronized (TestThread.class) {

    synchronized (TestThread.lock2) {
      System.out.println("One For Two lock2");

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (TestThread.lock3) {
        System.out.println("One For Two lock3");
      }
    }

    // }
  }
}
