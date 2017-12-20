package Tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/balanced-forest/problem
 * DFS/BFS
 *
 Sample input:
 1
 8
 1 1 1 18 10 11 5 6
 1 2
 1 4
 2 3
 1 8
 8 7
 6 7
 5 7
 */
public class BalancedForest {
    static class Node {
        int coins;
        int name;
        ArrayList<Node> children;

        public Node(int name, int coins){
            this.name = name;
            this.coins = coins;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            int n = in.nextInt();
            Node[] nodes = new Node[n];
            ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
            for(int j = 0; j < n; j++){
                nodes[j] = new Node(j, in.nextInt());
            }

            for(int j = 0; j < n-1; j++){
                int x = in.nextInt();
                int y = in.nextInt();
                nodes[x-1].children.add(nodes[y-1]);
                nodes[y-1].children.add(nodes[x-1]);
                edges.add(new Pair<>(x - 1, y - 1));
            }

            long answer = -1;
            for (int j = 0; j < edges.size()-1; j++) {
                for (int k = j+1; k < edges.size(); k++) {
                    // remove two edges
                    nodes[edges.get(j).getKey()].children.remove(nodes[edges.get(j).getValue()]);
                    nodes[edges.get(j).getValue()].children.remove(nodes[edges.get(j).getKey()]);
                    nodes[edges.get(k).getKey()].children.remove(nodes[edges.get(k).getValue()]);
                    nodes[edges.get(k).getValue()].children.remove(nodes[edges.get(k).getKey()]);

                    // find connected components - dfs
                    ArrayList<Long> sums = dfs(nodes);
                    if(sums.size() == 3){
                        long majority = -1;
                        if(sums.get(0) == sums.get(1)){
                            majority = sums.get(0);
                        }
                        if(sums.get(0) == sums.get(2)){
                            majority = sums.get(0);
                        }
                        if (sums.get(1) == sums.get(2)){
                            majority = sums.get(1);
                        }

                        if(majority != -1) {
                            long other = sums.get(0) ^ sums.get(1) ^ sums.get(2);
                            if(other <= majority){
                                if(answer == -1){
                                    answer = majority-other;
                                } else {
                                    answer = Math.min(answer, majority-other);
                                }
                            }
                        }
                    } else {
                        //System.out.println("Size not 3");
                    }

                    // put two edges back
                    nodes[edges.get(j).getKey()].children.add(nodes[edges.get(j).getValue()]);
                    nodes[edges.get(j).getValue()].children.add(nodes[edges.get(j).getKey()]);
                    nodes[edges.get(k).getKey()].children.add(nodes[edges.get(k).getValue()]);
                    nodes[edges.get(k).getValue()].children.add(nodes[edges.get(k).getKey()]);
                }
            }
            System.out.println(answer);

        }
        in.close();
    }

    public static ArrayList<Long> dfs(Node[] nodes){
        boolean[] visited = new boolean[nodes.length];
        ArrayList<Long> componentSums = new ArrayList<>();
        componentSums.add(recursiveDFS(nodes[0], visited));

        for (int i = 0; i < nodes.length; i++) {
            if(!visited[nodes[i].name]){
                componentSums.add(recursiveDFS(nodes[i], visited));
            }
        }

        return componentSums;

    }

    public static long recursiveDFS(Node n, boolean[] visited){
        visited[n.name] = true;
        long sum = n.coins;
        for(Node c: n.children) {
            if(!visited[c.name]){
                sum += recursiveDFS(c, visited);
            }
        }

        return sum;
    }
}
