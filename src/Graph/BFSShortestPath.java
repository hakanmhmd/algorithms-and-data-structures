package Graph;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 */
public class BFSShortestPath {
    private static  SimpleGraph g = new SimpleGraph(9);

    public static void BFSShortestPath(SimpleGraph g, int start, int end){
        // keep track of the visited nodes - mark as not visited at the beginning
        boolean[] visited = new boolean[g.getCount()];
        int[] prev = new int[g.getCount()];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1; //prev[x] = y means vertex x was visited right after vertex y
        }
        // create a queue using a linkedlist
        LinkedList<Integer> queue = new LinkedList<>();

        // mark start node as visited
        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0){
            // dequeue the element from the queue
            int element = queue.poll();

            //for each of its neighbours (adjacent vertices)
            // if not visited, mark it visited and enqueue
            Iterator<Integer> i = g.getNeighbours(element);
            while(i.hasNext()){
                int next = i.next();
                if(!visited[next]){
                    visited[next] = true;
                    prev[next] = element;
                    queue.add(next);
                }
            }

        }

        //printing the path - from end to start
        int currentV = end;
        ArrayList<Integer> path = new ArrayList<>();
        while(prev[currentV] != -1){
            path.add(currentV);
            currentV = prev[currentV];
        }
        path.add(start);
        Collections.reverse(path);
        System.out.println(path);
    }

    public static void main(String[] args) {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);
        g.addEdge(8, 7);
        g.addEdge(7, 2);

        BFSShortestPath(g, 0, 7);
    }
}
