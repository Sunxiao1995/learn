package club.banyuan;

public class MeasurableTest implements Measurable{
    Double a;
    public MeasurableTest(Double a) {
        this.a = a;
    }

    @Override
    public Double getMeasure() {
        return a;
    }
}
