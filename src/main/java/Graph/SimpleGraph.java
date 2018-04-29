package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Simple graph represented by adjacency list
 */
public class SimpleGraph {
    private int count;
    private LinkedList<Integer> adjList[];

    public SimpleGraph(int count){
        this.count = count;
        this.adjList = new LinkedList[count];
        for (int i = 0; i < count; i++) {
             adjList[i] = new LinkedList<Integer>();

        }
    }

    public int getCount(){
        return this.count;
    }

    public void addEdge(int source, int dest){
        if(source > count-1 || dest > count-1){
            System.out.println("Vertices does not exist.");
            return;
        }
        adjList[source].add(dest);
        adjList[dest].add(source);
    }

    public LinkedList<Integer>[] getNodes(){
        return adjList;
    }

    public LinkedList<Integer> getNode(int i){
        return adjList[i];
    }


    public Iterator<Integer> getNeighbours(int vertex){
        return adjList[vertex].listIterator();
    }

    public Iterator<Integer> getNeighbours(LinkedList<Integer> node){
        return node.listIterator();
    }

    public void print(){
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " -> ");
            LinkedList<Integer> neighbours = adjList[i];
            ListIterator<Integer> it = neighbours.listIterator();
            while(it.hasNext()){
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 4);

        g.print();
    }

}
