package club.banyuan;

public class RectangleMeasurer implements Measurer<Rectangle> {

  @Override
  public double measure(Rectangle anObject) {
      return ((Rectangle) anObject).width * ((Rectangle) anObject).height;
  }
}
