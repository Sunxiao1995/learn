package club.banyuan;

public class StringMeasurer<T> implements Measurer<T> {

  @Override
  public double measure(T anObject) {
    if (anObject == null) {
      return 0;
    }
    if (anObject instanceof String) {

      return ((String) anObject).length();
    }
    throw new IllegalArgumentException("不是字符串类");
  }
}
