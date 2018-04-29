package Graph;

import java.util.Iterator;
import java.util.Stack;

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

        recursiveDFS(start, visited);
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

    void DFSIter(SimpleGraph g, int start) {
        // Initially mark all vertices as not visited
        boolean[] visited = new boolean[g.getCount()];
        for (int i = 0; i < g.getCount(); i++)
            visited[i] = false;

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push the current source node
        stack.push(start);

        while(!stack.empty()) {
            // Pop a vertex from stack and print it
            Integer s = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if(!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then puah it
            // to the stack.
            Iterator<Integer> itr = g.getNeighbours(s);

            while (itr.hasNext())
            {
                int v = itr.next();
                if(!visited[v])
                    stack.push(v);
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
