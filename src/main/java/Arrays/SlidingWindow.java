package Arrays;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class SlidingWindow {
    static int solve(int[] s, int k, int w){
        int count = 0;

        int sum = 0;
        for(int i=0; i< w; i++){
            sum += s[i];
        }
        if(sum == k) count++;
        for(int i=0, j=w; j<s.length; i++, j++){
            sum = sum + s[j] - s[i];
            if(sum == k) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 1, 3, 2};
        int d = 3;
        int m = 2;
        int result = solve(s, d, m);
        System.out.println(result);
    }
}
