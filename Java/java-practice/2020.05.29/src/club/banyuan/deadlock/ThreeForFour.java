package club.banyuan.deadlock;

public class ThreeForFour implements Runnable {

  @Override
  public void run() {
    // synchronized (TestThread.class) {

    synchronized (TestThread.lock3) {
      System.out.println("One For Two lock3");

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (TestThread.lock4) {
        System.out.println("One For Two lock4");
      }
    }

    // }
  }
}
