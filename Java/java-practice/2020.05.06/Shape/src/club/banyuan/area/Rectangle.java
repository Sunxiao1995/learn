package club.banyuan.area;

public class Rectangle extends Shape{
    private double longs;
    private double wide;

    public Rectangle(double longs ,double wide){
        this.longs = longs;
        this.wide = wide;
    }

    @Override
    public String getShapeName() {
        return "矩形";
    }

    @Override
    public double area() {
        return longs*wide;
    }

    @Override
    public double perimeter() {
        return (longs+wide)*2;
    }
}
