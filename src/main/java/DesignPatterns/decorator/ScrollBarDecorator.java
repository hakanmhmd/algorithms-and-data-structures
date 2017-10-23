package DesignPatterns.decorator;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class ScrollBarDecorator extends Decorator implements GraphicalComponent {
    public ScrollBarDecorator(GraphicalComponent next) {
        super(next);
    }

    public void paint() {
        System.out.println("Render scrollbar here...");
        super.paint();
    }

    @Override
    public GraphicalComponent addContent(Object content) {
        return this;
    }
}
