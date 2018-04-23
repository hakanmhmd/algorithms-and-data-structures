package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 */
public class IsBipartite {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };

        System.out.println(isBipartite(arr));
    }

    // 2 colors - 0 and 1
    private static boolean isBipartite(int[][] graph) {
        if(graph==null || graph.length==0) return true;
        int colors[] = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i=0; i<graph.length; i++){
            if(colors[i] == -1){
                if(!assignColor(graph, colors, i)) return false;
            }
        }
        return true;
    }

    private static boolean assignColor(int[][] graph, int[] colors, int node) {
        colors[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Integer poll = q.poll();
            for(int n: graph[poll]){
                if(colors[n] == -1){
                    colors[n] = colors[poll] == 0 ? 1 : 0;
                    q.offer(n);
                } else if(colors[n] == colors[poll]){
                    return false;
                }
            }
        }

        return true;
    }
}
