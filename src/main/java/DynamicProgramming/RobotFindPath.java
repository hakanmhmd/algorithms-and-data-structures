package DynamicProgramming;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are
 * "off limits" such that the robot cannot step on them. Design an algorithm to find
 * a path for the robot from the top left to the bottom right.
 */
public class RobotFindPath {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true, true},
                {false, true, true, true},
                {true, true, true, true},
                {false, false, false, true}
        };


        ArrayList<Pair<Integer, Integer>> path = findPath(maze);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).getKey() + " " + path.get(i).getValue());
        }

        System.out.println(findNumberOfWays(maze) + " ways to reach end");


        maze = new boolean[][]{
                {false, false, true, true},
                {true, true, false, true},
                {true, true, true, true},
                {true, false, false, true}
        };
        System.out.println(findPathBottomLeftToBottomRight(maze));
    }

    private static ArrayList<Pair<Integer,Integer>> findPath(boolean[][] maze) {
        if(maze == null || maze.length == 0) return null;
        ArrayList<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        HashSet<Pair<Integer, Integer>> failedPoints = new HashSet<>();
        if(findPath(maze, 0, 0, path, failedPoints)){
            return path;
        }
        return null;
    }

    private static boolean findPath(boolean[][] maze, int row, int col, ArrayList<Pair<Integer, Integer>> path, HashSet<Pair<Integer, Integer>> failedPoints) {
        if(row > maze.length || col > maze.length || !maze[row][col]){
            return false;
        }

        Pair<Integer, Integer> p = new Pair<>(row, col);
        if(failedPoints.contains(p)) return false;

        boolean isAtDest = (row == maze.length-1) && (col == maze.length-1);
        if(isAtDest || findPath(maze, row+1, col, path, failedPoints) || findPath(maze, row, col+1, path, failedPoints)){
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    private static int findNumberOfWays(boolean[][] maze){
        int lastRow = maze.length-1;
        int lastCol = maze[0].length-1;
        int x = maze.length-2;
        int y = maze.length-2;

        int[][] auxMatrix = new int[maze.length][maze[0].length];


        // copy last col
        for(int i=lastCol; i>=0; i--){
            auxMatrix[lastRow][i] = maze[lastRow][i] ? 1 : 0;
        }

        // copy last row
        for(int i=lastRow; i>=0; i--){
            auxMatrix[i][lastCol] = maze[i][lastCol] ? 1 : 0;
        }

        for(int row=x; row>=0; row--){
            for(int col=y; col>=0; col--){
                if(maze[row][col]){
                    // we can only land current cell by going up or left (opposite to down and right)
                    auxMatrix[row][col] = auxMatrix[row+1][col] + auxMatrix[row][col+1];
                } else {
                    auxMatrix[row][col] = 0;
                }
            }
        }

        return auxMatrix[0][0];
    }


    /*
    Given the length and width of a matrix, get the number of paths from bottom-left to bottom right.
    You may only walk into those 3 directions ➡ (right) ↗ (upper-right) ↘ (lower-right) at each point.
    Follow-up: optimize 2d DP to 1d DP of linear extra space.
     */

    //The dp formula will be M[i,j] = M[i - 1, j - 1] + M[i - 1, j] + M[i - 1, j + 1]
    //Because one could only land on current cell from the 3 cells in the upper-left, left and lower-left.
    //To make the space consumption 1d, cache the numbers in one column of the matrix at a time.
    //Follow-up 2: Just reset path-counts for blocked cells to 0
    private static int findPathBottomLeftToBottomRight(boolean[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        if(!maze[rows-1][0] || !maze[rows-1][cols-1]) return 0;
        int[] oneCol = new int[rows];
        //start from bottom left
        oneCol[0] = 1;

        for(int col=1; col<cols; col++){
            int lower_left_value = 0;
            for(int row=0; row<rows; row++){
                int left_value = oneCol[row];
                int upper_left_value = row == rows - 1 ? 0 : oneCol[row + 1];
                oneCol[row] += lower_left_value + upper_left_value;
                if(!maze[rows-1-row][col]) oneCol[row] = 0;
                lower_left_value = left_value;
            }
        }

        return oneCol[0];

    }
}
