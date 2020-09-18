import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(5));

        System.out.println(shapes.get(0).getX() + " " + shapes.get(0).getY());
        shapes.get(0).move(1 , -2);
        System.out.println(shapes.get(0).getX() + " " + shapes.get(0).getY());
    }
}
