package DesignPatterns.factory;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class Client {
    private List<Shape> shapes;
    public Client() {
        shapes = new ArrayList<Shape>();
    }
    public void readShapes(String[] shapes) {
        for (String shape : shapes) {
            this.shapes.add(Shape.create(shape));
        }
    }

    public void drawShapes() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
