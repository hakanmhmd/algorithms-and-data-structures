package DynamicProgramming;


/**
 * Given 123 -> [ABC, LC, AW]
 */
public class NumberOfEncodings {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(encodings(s));
        System.out.println(encodingsDP(s));
    }

    private static int encodings(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return 1;

        int count = 0;
        if(s.charAt(len-1) > '0'){
            count += encodings(s.substring(0, len-1));
        }

        if(s.charAt(len-2) < '2' || (s.charAt(len-2) == '2' && s.charAt(len-1) < '7')){
            count += encodings(s.substring(0, len-2));
        }

        return count;
    }

    private static int encodingsDP(String s){
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
