package DynamicProgramming;


/**
 * Given 123 -> [ABC, LC, AW]
 */
public class NumberOfEncodings {
    public static void main(String[] args) {
        String s = "123";
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
        int len = s.length();
        int[] dp = new int[len+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=len; i++){
            if(s.charAt(i-1) > '0'){
                dp[i] = dp[i-1];
            }

            if(s.charAt(i-2) < '2' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7')){
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[len];
    }
}
