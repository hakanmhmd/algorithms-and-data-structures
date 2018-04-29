package Backtracking;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number
 * of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:

 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other keys, the other
 keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 The order of keys used matters.
 */
public class AndroidUnlockPatterns {
    public static void main(String[] args) {
        int m = 1;
        int n = 9;

        System.out.println(patternsCount(m, n));
    }

    private static int patternsCount(int m, int n) {
        int[][] between = new int[10][10];
        between[1][9] = between[9][1] = between[2][8] = between[8][2]
                = between[3][7] = between[7][3] = between[4][6] = between[6][4] = 5;
        between[1][3] = between[3][1] = 2;
        between[1][7] = between[7][1] = 4;
        between[3][9] = between[9][3] = 6;
        between[7][9] = between[9][7] = 8;

        boolean[] visited = new boolean[10];
        int count = 0;
        // DFS search each length from m to n
        for (int i = m; i <= n; ++i) {
            count += DFS(visited, between, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            count += DFS(visited, between, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            count += DFS(visited, between, 5, i - 1);        // 5
        }
        return count;
    }

    private static int DFS(boolean[] visited, int[][] between, int curr, int remaining) {
        if(remaining < 0) return 0;
        if(remaining == 0) return 1;
        visited[curr] = true;
        int c = 0;
        for(int i=1; i<=9; i++){
            if(!visited[i] && (between[curr][i] == 0 || visited[between[curr][i]])){
                c += DFS(visited, between, i, remaining-1);
            }
        }
        visited[curr] = false;
        return c;
    }
}
