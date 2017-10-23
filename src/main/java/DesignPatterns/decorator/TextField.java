package DesignPatterns.decorator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hakanmehmed on 04/07/2017.
 */
public class TextField implements GraphicalComponent{
    private List<String> lines = new LinkedList<String>();

    public void paint() {
        System.out.println("---Start---");
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("---End---");
    }

    public GraphicalComponent addContent(Object content) {
        assert(content instanceof String);
        this.lines.add((String) content);
        if(this.lines.size() >= 5){
            return new ScrollBarDecorator(this);
        }
        return this;
    }
}
