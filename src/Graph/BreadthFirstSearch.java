package Graph;


import java.util.Iterator;
import java.util.LinkedList;

/**
 *  BFS O(V+E) where V is the number of vertices and E is the number of edges
 *  Uses of BFS
 *    shortest path
 *    p2p networks
 *    social networks
 *
 *
 */
public class BreadthFirstSearch {
    private static  SimpleGraph g = new SimpleGraph(9);

    public static void BFS(SimpleGraph g, int start){
        // keep track of the visited nodes - mark as not visited at the beginning
        boolean[] visited = new boolean[g.getCount()];

        // create a queue using a linkedlist
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // mark start node as visited
        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0){
            // dequeue the element from the queue
            int element = queue.poll();
            System.out.print(element + " ");

            //for each of its neighbours (adjacent vertices)
            // if not visited, mark it visited and enqueue
            Iterator<Integer> i = g.getNeighbours(element);
            while(i.hasNext()){
                int next = i.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
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

        BFS(g, 0);
    }
}
