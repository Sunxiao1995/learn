package club.banyuan;

class MaxThread extends Thread {

  private int lo, hi;
  private int[] arr;
  private double ans = 0;

  public MaxThread(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  @Override
  public void run() {
    ans = Math.sin(arr[lo]);
    for (int i = lo; i < hi; i++) {
      double sin = Math.sin(arr[i]);
      if (ans < sin) {
        ans = sin;
      }
    }
  }

  public double getAns() {
    return ans;
  }
}

public class MaxMultithreaded {

  /**
   * 计算数组元素的sin值之后，返回最大值。
   *
   * @param arr 目标数组
   * @return sin(数组元素)的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    double ans = Double.NEGATIVE_INFINITY;

    // 创建并启动线程。
    MaxThread[] ts = new MaxThread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      ts[i] = new MaxThread(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
      ts[i].start();
    }

    // 等待线程完成并计算它们的结果。
    for (int i = 0; i < numThreads; i++) {
      ts[i].join();

      if (ans < ts[i].getAns()) {
        ans = ts[i].getAns();
      }
    }
    return ans;
  }
}
