public class Circle extends Shape{
    public final double PI = Math.PI;
    public final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return radius * radius * PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * PI;
    }
}
