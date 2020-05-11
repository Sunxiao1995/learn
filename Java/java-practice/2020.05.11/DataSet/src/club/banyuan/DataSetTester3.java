package club.banyuan;

public class DataSetTester3 {

  public static void main(String[] args) {

    Measurer m = new StringMeasurer();
    DataSet data = new DataSet(m);
    data.add(new StringMeasurer("test"));
    data.add(new StringMeasurer("testing"));
    data.add(new StringMeasurer("tester"));
    data.add(new StringMeasurer("retest"));
    data.add(new StringMeasurer("contest"));
    System.out.println("Average length: " + data.getAverage());
    System.out.println("输出值: 6");
    StringMeasurer maxlength = (StringMeasurer) data.getMaximum();

    //String maxlength = (String) data.getMaximum();  // Type casting 这样转报错了不会转
    System.out.println("最大长度的字符串是: " + maxlength.measurerName);
    System.out.println("输出值:testing");
  }
}
