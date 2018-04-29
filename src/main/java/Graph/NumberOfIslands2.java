package Graph;

import java.util.Arrays;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which
 * turns the water at position (row, col) into a land. Given a list of positions to operate, count the number
 * of islands after each addLand operation. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        };


        numberOfIslands(m, n ,positions);
    }

    // basically a union find problem
    // an island is presented as a tree with parent element
    private static void numberOfIslands(int m, int n, int[][] positions) {
        int[] rootArray = new int[m*n];
        Arrays.fill(rootArray, -1);
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int count = 0;
        for(int k=0; k<positions.length; k++){
            count++;
            int[] position = positions[k];
            int index = position[0]*n + position[1];

            rootArray[index] = index; // its own parent

            for(int i=0; i<4; i++){
                int r = position[0] + directions[i][0];
                int c = position[1] + directions[i][1];

                if(r>=0 && c>=0 && r<m && c<n && rootArray[r*n+c]!=-1){
                    int root = getRoot(rootArray, r*n+c);
                    if(root != index){
                        count--;
                        rootArray[root] = index;
                    }
                }
            }

            System.out.println(count + " ");
        }

    }

    private static int getRoot(int[] rootArray, int i) {
        while(i != rootArray[i]){
            i = rootArray[i];
        }
        return i;
    }
}
