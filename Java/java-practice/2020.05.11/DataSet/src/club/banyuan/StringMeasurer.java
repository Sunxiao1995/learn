package club.banyuan;

public class StringMeasurer implements Measurer {
  // TODO: 创建实现Measurer接口的StringMeasurer类。提示：measure（）应该返回字符串的长度。
    public String measurerName;
    public StringMeasurer(){

    }
    public StringMeasurer(String measurer) {
     measurerName = measurer;
    }

    @Override
    public double measure(Object anObject) {
      StringMeasurer anString = (StringMeasurer)anObject;
        return anString.measurerName.length();
    }
}
