package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array find an increasing subsequence with max sum (not necessarily longest)
 */
public class MaxIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {4, 6, 1, 3, 8, 4, 6};
        ArrayList<Integer> seq = findMaxIncreasingSubsequence(input);
        Collections.reverse(seq);
        System.out.println(seq);
    }

    private static ArrayList<Integer> findMaxIncreasingSubsequence(int[] input) {
        int[] temp = new int[input.length];
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
            result[i] = i;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if(input[j] < input[i]){
                    if(temp[j] + input[i] > temp[i]) {
                        temp[i] = input[i] + temp[j];
                        result[i] = j;
                        if(temp[i] > max){
                            max = temp[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> sequence = new ArrayList<>();

        int previousMaxIndex = -1;
        while(maxIndex != previousMaxIndex){
            int element = input[maxIndex];
            sequence.add(element);
            previousMaxIndex = maxIndex;
            maxIndex = result[maxIndex];
        }

        return sequence;
    }
}
