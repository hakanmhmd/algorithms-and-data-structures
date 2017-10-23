package DesignPatterns.factory;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public abstract class Shape {
    abstract void draw();

    static Shape create(String shape) {
        Shape s = null;
        if(shape.startsWith("#rect")){
            s = new Rectangle();
        } else if(shape.startsWith("#oval")){
            s = new Oval();
        } else if(shape.startsWith("#line")){
            s = new Line();
        }

        return s;
    }
}
