package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * iven a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a
 * given source cell to a destination cell. The path can only be created out of a cell if its value is 1.
 */
public class MazeShortestPath {
    static class Point {
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Node {
        Point p;
        int distance;

        public Node(Point p, int distance) {
            this.p = p;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        int[][] mat  = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        Point source = new Point(0, 0);
        Point dest = new Point(3,4);
        System.out.println(path(mat, source, dest));
    }
    static int rows[] = {-1, 0, 0, 1};
    static int cols[] = {0, -1, 1, 0};
    private static int path(int[][] mat, Point source, Point dest) {
        if(mat[source.x][source.y] == 0 || mat[dest.x][dest.y] == 0) return Integer.MAX_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(source, 0));
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        visited[source.x][source.y] = true;

        while(!q.isEmpty()){
            Node n = q.poll();
            Point p = n.p;
            if(p.x == dest.x && p.y == dest.y) return n.distance;

            for(int i=0; i<4; i++){
                int row = p.x + rows[i];
                int col = p.y + cols[i];

                if(isValid(row, col, mat) && mat[row][col] == 1 && !visited[row][col]){
                    visited[row][col] = true;
                    q.offer(new Node(new Point(row, col), n.distance+1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isValid(int row, int col, int[][] mat) {
        return (row >= 0) && (row < mat.length) &&
                (col >= 0) && (col < mat[0].length);
    }
}
