package club.banyuan.area;

public class Rectangle extends Shape{
    private final double longs;  //如果定义出来不希望被修改 可以定义为final，然后值提供get 方法
    private final double wide;

    public double getLongs() {
        return longs;
    }

    public double getWide() {
        return wide;
    }

    public Rectangle(double longs , double wide){
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
