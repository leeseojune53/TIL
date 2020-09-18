public abstract class AbstractShape {
    // 그림판에서의 위치
    protected double x;
    protected double y;

    // 생성자
    public AbstractShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 도형 움직이기
    public void move(double xDistance, double yDistance) {
        x += xDistance;
        y += yDistance;
    }
}