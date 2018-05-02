package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };

        System.out.println(isValid(n, edges));

        edges = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };
        System.out.println(isValid(n, edges));
    }

    private static boolean isValid(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Cycle in undirected graph ??
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(dfs(graph, i, visited, -1)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int i, boolean[] visited, int parent) {
        visited[i] = true;
        ArrayList<Integer> neighbours = graph.get(i);
        for(int n: neighbours){
            if(!visited[n]){
                dfs(graph, n, visited, i);
            } else if(n != parent) {
                return true;
            }
        }
        return false;
    }
}
