public abstract class Shape {
    private double x,y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
