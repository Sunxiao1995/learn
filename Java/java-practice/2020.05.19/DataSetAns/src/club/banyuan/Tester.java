package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tester {

  @Test
  public void countryTest() {
    DataSet<Country> date = new DataSet<>(new MeasurableMeasurer<>());
    date.add(new Country(19920));
    date.add(new Country(20000));
    date.add(new Country(45000));
    date.add(new Country(1110));
    Assert.assertEquals("最大人口数量", 45000, date.getMaximum().getMeasure(), 0);
  }

  @Test
  public void rectangleMeasurerTest() {
    Measurer<Rectangle> m = new RectangleMeasurer();
    DataSet<Rectangle> data = new DataSet<>(m);
    data.add(new Rectangle(15, 10));
    data.add(new Rectangle(40, 20));
    data.add(new Rectangle(20, 10));
    Assert.assertEquals("平均面积", 383, data.getAverage(), 1);
    Assert.assertEquals("最大面积矩形: ", new Rectangle(40, 20), data.getMaximum());
  }

  @Test
  public void stringMeasurerTest() {
    Measurer<String> m = new StringMeasurer();
    DataSet<String> data = new DataSet<>(m);
    data.add("test");
    data.add("testing");
    data.add("tester");
    data.add("retest");
    data.add("contest");
    Assert.assertEquals("平均长度:", 6, data.getAverage(), 0);
    Assert.assertEquals("最大长度的字符串", "testing", data.getMaximum());
  }

  @Test
  public void distanceTest() {
    double a = 1.2;
    double b = 1.3;
    if (Math.abs(b - a) > 0.0000001) {

    }

    DataSet<Distance> date = new DataSet<>(new MeasurableMeasurer<>());
    date.add(new Distance(1000));
    date.add(new Distance(2000));
    date.add(new Distance(3000));
    date.add(new Distance(4000));
    Assert.assertEquals("平均距离：", 2500, date.getAverage(), 0);
    Assert.assertEquals("最长距离：", 4000, date.getMaximum().getMeasure(), 0);
  }
}
