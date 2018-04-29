package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Searching a graph is quite famous problem and have a lot of practical use. We have already discussed here how
 * to search for a goal vertex starting from a source vertex using BFS. In normal graph search using BFS/DFS
 * we begin our search in one direction usually from source vertex toward the goal vertex, but what if we
 * start search form both direction simultaneously.
 *
 * b - branching factor
 * d - distance
 * BFS - O(b^d)
 * BiBFS - O(b^d/2 + b^d/2)
 */
public class BidirectionalBFS {
    private static  SimpleGraph g = new SimpleGraph(15);
    public static void main(String[] args) {
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(7, 8);
        g.addEdge(6, 7);
        g.addEdge(8, 9);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(8, 10);
        g.addEdge(10, 13);
        g.addEdge(10, 14);

        bidirectionalBFS(g, 0, 14);
    }

    private static void bidirectionalBFS(SimpleGraph g, int start, int end) {
        boolean[] s_visited = new boolean[g.getCount()];
        boolean[] e_visited = new boolean[g.getCount()];

        int[] s_parent = new int[g.getCount()];
        int[] e_parent = new int[g.getCount()];

        LinkedList<Integer> s_queue = new LinkedList<>();
        LinkedList<Integer> e_queue = new LinkedList<>();

        s_queue.offer(start);
        e_queue.offer(end);

        s_visited[start] = true;
        e_visited[end] = true;

        s_parent[start] = -1;
        e_parent[end] = -1;

        while(!s_queue.isEmpty() && !e_queue.isEmpty()){
            bfs(s_queue, s_parent, s_visited);
            bfs(e_queue, e_parent, e_visited);

            int intersectNode = isIntersecting(s_visited, e_visited);

            if(intersectNode != -1){
                printPath(s_parent, e_parent, start, end, intersectNode);
                return;
            }
        }
    }

    private static void printPath(int[] s_parent, int[] e_parent, int start, int end, int intersectNode) {
        ArrayList<Integer> path = new ArrayList<>();
        int i = intersectNode;
        path.add(intersectNode);
        while(i != start){
            path.add(s_parent[i]);
            i = s_parent[i];
        }
        Collections.reverse(path);
        i = intersectNode;
        while(i != end){
            path.add(e_parent[i]);
            i = e_parent[i];
        }

        System.out.println(path);
    }

    private static int isIntersecting(boolean[] s_visited, boolean[] e_visited) {
        for(int i=0; i< g.getCount(); i++){
            if(s_visited[i] && e_visited[i]){
                return i;
            }
        }
        return -1;
    }

    private static void bfs(LinkedList<Integer> queue, int[] parent, boolean[] visited) {
        Integer current = queue.poll();
        Iterator<Integer> i = g.getNeighbours(current);
        while(i.hasNext()){
            int node = i.next();
            if(!visited[node]){
                parent[node] = current;
                visited[node] = true;
                queue.add(node);
            }
        }
    }
}
