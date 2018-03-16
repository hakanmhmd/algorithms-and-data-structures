package DynamicProgramming;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        int[] seq = {1, 3, 5, 7, 9, 15, 20, 25, 28, 29};
        System.out.println(countArithmeticSeq(seq));
        System.out.println(countArithmeticSeq2(seq));
        System.out.println(countArithmeticSeqFormula(seq));
    }

    // linear space
    private static int countArithmeticSeq(int[] seq) {
        int[] dp = new int[seq.length];

        for(int i=2; i<seq.length; i++){
            if(seq[i] - seq[i-1] == seq[i-1] - seq[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }

        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        return sum;
    }

    //constant space
    private static int countArithmeticSeq2(int[] seq) {
        int dp = 0;
        int sum = 0;
        for(int i=2; i<seq.length; i++){
            if(seq[i] - seq[i-1] == seq[i-1] - seq[i-2]){
                dp = dp + 1;
                sum+=dp;
            } else {
                dp = 0;
            }
        }
        return sum;
    }

    //count∗(count+1)/2
    private static int countArithmeticSeqFormula(int[] seq) {
        int count = 0;
        int sum = 0;
        for(int i=2; i<seq.length; i++){
            if(seq[i] - seq[i-1] == seq[i-1] - seq[i-2]){
                count++;
            } else {
                sum += count * (count+1)/2;
                count = 0;
            }
        }
        sum += count * (count+1)/2;
        return sum;
    }


}
