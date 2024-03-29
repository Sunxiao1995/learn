package club.banyuan.deadlock;

public class FourForFive implements Runnable {

  @Override
  public void run() {
    // synchronized (TestThread.class) {

    synchronized (TestThread.lock4) {
      System.out.println("One For Two lock4");

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (TestThread.lock5) {
        System.out.println("One For Two lock5");
      }
    }

    // }
  }
}
