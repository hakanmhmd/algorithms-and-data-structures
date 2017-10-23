package DesignPatterns.factory;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        String[] shapes = {
                "#rect 1,2,100,200",
                "#oval 1,1,100,100",
                "#line"
        };

        Client c = new Client();
        c.readShapes(shapes);
        c.drawShapes();
    }
}
