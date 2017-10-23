package DesignPatterns.decorator;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public abstract class Decorator implements GraphicalComponent {
    private GraphicalComponent next;

    public Decorator(GraphicalComponent next) {
        this.next = next;
    }

    public void paint(){
        this.next.paint();
    }

    public GraphicalComponent addContent(Object content) {
        return this;
    }
}
