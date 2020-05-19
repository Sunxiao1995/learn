package club.banyuan;

public class MeasurableMeasurer<T extends Measurable> implements Measurer<T>{
    @Override
    public double measure(Measurable anObject) {
        return anObject.getMeasure();
    }
}
