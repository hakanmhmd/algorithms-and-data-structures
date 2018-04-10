package DynamicProgramming;


/**
 * Given 123 -> [ABC, LC, AW]
 */
public class NumberOfEncodings {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(encodings(s));
        System.out.println(encodingsDP(s));
        System.out.println(encodingsDPspace(s));

        s = "00";
        System.out.println(encodings(s));
        System.out.println(encodingsDP(s));
        System.out.println(encodingsDPspace(s));
    }

    private static int encodings(String s) {
        return s.isEmpty() ? 0 : encodings(0, s);

    }

    static int encodings(int i, String s){
        int len = s.length();
        if(i == len) return 1;
        if(s.charAt(i) == '0') return 0;

        int count = encodings(i+1, s);


        if(i < len-1 && s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')){
            count += encodings(i+2, s);
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

    private static int encodingsDPspace(String s){
        int len = s.length();
        int p =1;
        int pp = 0;
        for(int i=len-1; i>=0; i--){
            int curr = s.charAt(i) == '0' ? 0 : p;
            if(i<len-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) curr += pp;
            pp = p;
            p = curr;
        }

        return len == 0 ? 0 : p;
    }
}
