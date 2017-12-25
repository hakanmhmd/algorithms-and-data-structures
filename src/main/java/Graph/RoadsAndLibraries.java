package Graph;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class RoadsAndLibraries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int cities = in.nextInt();
            int roads = in.nextInt();
            long libCost = in.nextLong();
            long roadCost = in.nextLong();
            if(libCost <= roadCost) {
                System.out.println(libCost * cities);
                for (int i = 0; i < (roads*2); i++){
                    in.nextInt();
                }
                continue;
            }
            LinkedList<Integer>[] adjList = new LinkedList[cities+1];
            for(int i=0; i<=cities; i++){
                adjList[i] = new LinkedList<>();
            }
            for(int a1 = 0; a1 < roads; a1++){
                int c1 = in.nextInt();
                int c2 = in.nextInt();
                adjList[c1].add(c2);
                adjList[c2].add(c1);
            }

            //run dfs

            boolean[] visited = new boolean[cities+1];
            int components = 0;
            for (int i = 1; i <= cities; i++) {
                if(!visited[i]){
                    dfs(i, visited, adjList);
                    components++;
                }
            }
            long price = roadCost * (cities-components) + libCost * components;
            System.out.println(price);

        }
    }

    static void dfs(int node, boolean[] visited, LinkedList<Integer>[] adjList){
        visited[node] = true;
        Iterator<Integer> i = adjList[node].listIterator();
        while(i.hasNext()){
            Integer next = i.next();
            if(!visited[next]){
                dfs(next, visited, adjList);
            }
        }

    }
}
