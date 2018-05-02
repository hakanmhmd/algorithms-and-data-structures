package Graph;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region. Pixels are connected
 * horizontally and vertically. Given the location (x, y) of one of the black pixels, return
 * the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 */
public class SmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
        int[][] m = {
                {0,0,1,0},
                {0,1,1,0},
                {0,1,0,0}
        };

        int x = 0;
        int y = 2;

        System.out.println(area(m, x, y));
    }
    private static int top, bottom, left, right;
    private static int area(int[][] m, int x, int y) {
        if(m == null || m.length == 0){
            return 0;
        }
        top = bottom = x;
        left = right = y;

        dfs(m, x, y);
        return (right-left+1) * (bottom-top+1);
    }

    private static void dfs(int[][] m, int x, int y) {
        if(x<0 || y<0 || x>=m.length || y>=m[0].length || m[x][y] == 0){
            return;
        }

        m[x][y] = 0;
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);

        dfs(m, x+1, y);
        dfs(m, x-1, y);
        dfs(m, x, y+1);
        dfs(m, x, y-1);
    }
}
