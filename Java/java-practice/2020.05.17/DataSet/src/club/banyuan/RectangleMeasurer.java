package club.banyuan;

public class RectangleMeasurer<T> implements Measurer<T> {

  @Override
  public double measure(T anObject) {
    if (anObject instanceof Rectangle) {
      return ((Rectangle) anObject).width * ((Rectangle) anObject).height;
    }
    throw new IllegalArgumentException("不是矩形类");
  }
}
