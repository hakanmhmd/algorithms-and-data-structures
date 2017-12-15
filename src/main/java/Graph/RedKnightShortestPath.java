package Graph;
import java.util.*;

public class RedKnightShortestPath {
    static class BoardPosition {
        int x;
        int y;
        int distance;

        public BoardPosition(int x, int y){
            this.x = x;
            this.y = y;
        }

        public BoardPosition(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }

    // all the moves that the figure can make
    static int[] row = {-2, -2, 0, 2, 2, 0};
    static int[] col = {-1, 1, 2, 1, -1, -2};
    static String[] move = {"UL", "UR", "R", "LR", "LL", "L"};

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
        boolean visited[][] = new boolean[n][n];
        int previous[][] = new int[n][n];
        for (int[] row: previous) {
            Arrays.fill(row, -1);
        }
        BoardPosition start = new BoardPosition(i_start, j_start);
        start.distance = 0;
        visited[i_start][j_start] = true;
        BoardPosition end = new BoardPosition(i_end, j_end);

        LinkedList<BoardPosition> queue = new LinkedList<>();
        queue.add(start);

        while(queue.size() != 0){
            BoardPosition node = queue.poll();
            if(node.x == end.x && node.y == end.y){
                System.out.println(node.distance);
                break;
            }

            // performs possible moves
            for(int i=0; i<6; i++){
                int newX = node.x + row[i];
                int newY = node.y + col[i];
                BoardPosition newPos = new BoardPosition(newX, newY, node.distance+1);
                if(isValidPosition(newX, newY, n)){
                    if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        previous[newX][newY] = i; // previous stores the move that was taken
                        queue.add(newPos);
                    }
                }
            }
        }

        int currX = i_end;
        int currY = j_end;
        ArrayList<String> path = new ArrayList<>();
        if(previous[currX][currY] == -1){
            System.out.println("Impossible");
        } else {
            while(previous[currX][currY] != -1){
                int i = previous[currX][currY];
                // calculate the new positions based on the move taken
                currX -= row[i];
                currY -= col[i];
                path.add(move[i]);
            }
            Collections.reverse(path);
            for(String s: path){
                System.out.print(s + " ");
            }
        }

    }

    public static boolean isValidPosition(int x, int y, int n){
        if(x<0 || x>=n || y<0 || y>=n) return false;
        return true;
    }

    public static void main(String[] args) {
        printShortestPath(7, 0, 3, 4, 3);
    }
}
