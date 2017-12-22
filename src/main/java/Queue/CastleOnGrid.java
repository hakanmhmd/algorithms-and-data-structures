package Queue;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 */
public class CastleOnGrid {
    static class Position {
        int x;
        int y;
        int d;


        public Position(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int minimumMoves(char[][] grid, int startX, int startY, int goalX, int goalY) {
        LinkedList<Position> queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid.length];
        Position start = new Position(startX, startY, 0);
        queue.add(start);
        int minMoves = Integer.MAX_VALUE;
        while(queue.size() != 0){
            Position p = queue.remove();
            if(p.x == goalX && p.y == goalY){
                if(p.d < minMoves) minMoves = p.d;
                continue;
            }

            // vertically up
            int currentX = p.x;
            int currentY = p.y;
            while(true){
                int newX = currentX - 1;
                int newY = currentY;
                Position newpos = new Position(newX, newY, p.d+1);
                if(isValid(newX, newY, grid)){
                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(newpos);
                    }
                } else {
                    break;
                }
                currentX = newX;
                currentY = newY;
            }

            // vertically down
            currentX = p.x;
            currentY = p.y;
            while(true){
                int newX = currentX + 1;
                int newY = currentY;
                Position newpos = new Position(newX, newY, p.d+1);
                if(isValid(newX, newY, grid)){
                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(newpos);
                    }
                } else {
                    break;
                }
                currentX = newX;
                currentY = newY;
            }

            // horizontally left
            currentX = p.x;
            currentY = p.y;
            while(true){
                int newX = currentX;
                int newY = currentY - 1;
                Position newpos = new Position(newX, newY, p.d+1);
                if(isValid(newX, newY, grid)){
                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(newpos);
                    }
                } else {
                    break;
                }
                currentX = newX;
                currentY = newY;
            }

            // horizontally right
            currentX = p.x;
            currentY = p.y;
            while(true){
                int newX = currentX;
                int newY = currentY + 1;
                Position newpos = new Position(newX, newY, p.d+1);
                if(isValid(newX, newY, grid)){
                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.add(newpos);
                    }
                } else {
                    break;
                }
                currentX = newX;
                currentY = newY;
            }
        }
        return minMoves;
    }

    public static boolean isValid(int x, int y, char[][] grid){
        if(x<0 || x>=grid.length || y<0 || y>=grid.length || grid[x][y] == 'X') return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            String next = in.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = next.charAt(j);
            }
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int goalX = in.nextInt();
        int goalY = in.nextInt();
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
        in.close();
    }
}
