package DesignPatterns.decorator;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public interface GraphicalComponent {
    void paint();
    GraphicalComponent addContent(Object content);
}
