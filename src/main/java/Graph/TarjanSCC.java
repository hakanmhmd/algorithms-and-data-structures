package Graph;

import java.util.*;

/**
 * Created by hakanmehmed on 28/02/2018.
 */
public class TarjanSCC {
    private static  SimpleGraph g = new SimpleGraph(9);
    private static int index = 0;
    private static Stack<Integer> stack = new Stack<>();
    static Integer[] indexes = null;
    static Integer[] lowLinks = null;
    static Boolean[] onStack = null;

    static void findConnectedComponents(SimpleGraph g){
        LinkedList<Integer>[] nodes = g.getNodes();
        indexes = new Integer[nodes.length];
        lowLinks = new Integer[nodes.length];
        onStack = new Boolean[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            LinkedList<Integer> node = nodes[i];
            if(indexes[i] == null){
                strongConnect(node, i);
            }
        }

    }

    private static void strongConnect(LinkedList<Integer> node, int i) {
        indexes[i] = index;
        lowLinks[i] = index;
        index = index + 1;
        stack.push(i);
        onStack[i] = true;

        Iterator<Integer> neighbours = g.getNeighbours(node);
        while(neighbours.hasNext()){
            Integer next = neighbours.next();
            if(indexes[next] == null){
                strongConnect(g.getNode(next), next);
                lowLinks[i] = Math.min(lowLinks[next], lowLinks[i]);
            } else if(onStack[next]) {
                lowLinks[i] = Math.min(lowLinks[i], indexes[next]);
            }
        }

        if(Objects.equals(lowLinks[i], indexes[i])){
            ArrayList<Integer> component = new ArrayList<>();
            Integer pop = null;
            do {
                pop = stack.pop();
                onStack[pop] = false;
                component.add(pop);
            } while(pop != i);

            System.out.println(component);
        }


    }

    public static void main(String[] args) {
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        g.addEdge(3, 7);

        g.addEdge(7, 6);
        g.addEdge(4, 6);

        g.addEdge(0, 8);

        findConnectedComponents(g);
    }
}
