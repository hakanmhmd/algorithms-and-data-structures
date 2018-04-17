package Graph;

/**
 * Color a graph such that no two adjacent nodes have the same color
 */
public class GraphColoring {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1 ,0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 0},
        };

        int colors = 3;

        System.out.println(graphColor(graph, colors));
    }

    static int V, numColors;
    static int[] colors;
    static int[][] g;
    private static boolean graphColor(int[][] graph, int c) {
        V = graph.length;
        numColors = c;
        colors = new int[V];
        g = graph;
        boolean res = solve(0);

        for (int i = 0; i < V; i++)
            System.out.print(colors[i] +" ");

        return res;
    }

    private static boolean solve(int current) {
        if(current == V){
            return true;
        }

        for(int c=1; c<=numColors; c++){
            if(isPossible(current, c)){
                colors[current] = c;
                if(solve(current+1)){
                    return true;
                }
                // wrong assignment
                colors[current] = 0;
            }
        }

        return false;
    }

    private static boolean isPossible(int current, int c) {
        for(int i=0; i<V; i++){
            if(g[current][i] == 1 && colors[i] == c){
                return false;
            }
        }
        return true;
    }
}
