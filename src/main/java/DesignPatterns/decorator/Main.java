package DesignPatterns.decorator;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        GraphicalComponent c = constructPoem();
        c = new BorderDecorator(c);
        c.paint();
    }

    private static GraphicalComponent constructPoem() {
        GraphicalComponent tf = new TextField();
        tf = tf.addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....")
                .addContent("Sample lines....");

        return tf;
    }
}
