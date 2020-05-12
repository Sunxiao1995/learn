package club.banyuan;

public class DataSet {
  // TODO: 定义private 实例变量
  public int sum;
  public int count;
  public Measurer maximum;
  public Measurer measurer;


  public DataSet(Measurer aMeasurer) {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  // TODO： 重载方法，使得Country统计 DataSetTester 运行成功
  public void add(Object x) {
    sum = (int) (sum + measurer.measure(x));
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = (Measurer)x;
    }
    count++;
  }


  public double getAverage() {
    if(count == 0){
      System.out.println("没有数据");
      return 0;
    }
    return sum/count;
    // TODO: Check divide by zero. Compute the average value.
  }

  public Object getMaximum() {
    return maximum;
  }


}