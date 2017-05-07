package Graph;

import java.util.Iterator;

/**
 * O(V+E) where V is the number of vertices and E is the number of edges
 * Uses of DFS:
 *   solving maze
 *   detecting cycles
 *   pathfinding
 */
public class DepthFirstSearch {
    private static  SimpleGraph g = new SimpleGraph(9);

    public static void DFS(SimpleGraph g, int start){
        // mark all unvisited
        boolean[] visited = new boolean[g.getCount()];

        // not every vertex is reachable (disconnected graphs)
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                recursiveDFS(i, visited);
            }
        }

    }

    public static void recursiveDFS(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");

        // get all neighbours
        Iterator<Integer> i = g.getNeighbours(v);
        while(i.hasNext()){
            int next = i.next();
            if(!visited[next]){
                recursiveDFS(next, visited);
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

        DFS(g, 0);
    }

}
