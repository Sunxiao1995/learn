package club.banyuan.RefineCode;

class MaxThread extends Thread{
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
    for(int i = lo + 1; i < hi; i++){
      double t = Math.sin(arr[i]);
      if( t > ans){
        ans = t;
      }
    }
  }

  public double getAns() {
    return ans;
  }
}


public class MaxMultithreaded {

  /**
   * 求数组元素的最大值。
   *
   * @param arr 目标数组
   * @return 数组元素的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    double ans = 0;

    // 创建并启动线程。
    MaxThread[] ts = new MaxThread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      ts[i] = new MaxThread(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
      ts[i].start();
    }

    // 等待线程完成并计算它们的结果。
    for (int i = 0; i < numThreads; i++) {
      ts[i].join();
      if(ts[i].getAns() > ans){
        ans = ts[i].getAns();
      }
    }

    return ans;

  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println(max(new int[]{3,4,5,6,1,7,8,9},4));
  }

}
