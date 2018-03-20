package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * O(ElogV)
 */
public class Dijkstra {
    private static  SimpleGraph g = new SimpleGraph(9);

    public static void main(String[] args) {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(8, 5);
        g.addEdge(6, 7);
        g.addEdge(8, 7);
        g.addEdge(2, 7);
        g.addEdge(0, 8);

        djikstra(g, 0);
    }

    private static void djikstra(SimpleGraph g, int startNode) {
        int dist[] = new int[g.getCount()];
        int parent[] = new int[g.getCount()];
        boolean visited[] = new boolean[g.getCount()];
        for (int i = 0; i < g.getCount(); i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            visited[i] = false;
        }
        dist[startNode] = 0;

        for(int i=0; i<g.getCount()-1; i++) {
            int n = findNodeWithMinDistance(g, dist, visited); // needs to be heap
            visited[n] = true;
            Iterator<Integer> neighbours = g.getNeighbours(n);
            while(neighbours.hasNext()){
                Integer next = neighbours.next();
                if(!visited[next]) {

                    if (dist[next] >= dist[n] + 1){
                        dist[next] = dist[n] + 1; //weight
                        parent[next] = n;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(parent));
    }

    private static int findNodeWithMinDistance(SimpleGraph g, int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int node = -1;
        for(int i=0; i<g.getCount(); i++){
            if(!visited[i] && dist[i] <= min){
                min = dist[i];
                node = i;
            }
        }

        return node;
    }
}
