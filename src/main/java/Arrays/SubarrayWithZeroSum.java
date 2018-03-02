package Arrays;

import java.util.HashMap;

/**
 * Created by hakanmehmed on 02/03/2018.
 */
public class SubarrayWithZeroSum {
    public static void main(String arg[]) {
        int arr[] = {-3, 2, 3, 1, -4, 6};
        System.out.println(zeroSumSubArray(arr));
    }

    private static boolean zeroSumSubArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(arr[i] == 0 || sum == 0 || map.containsKey(sum)) {
                int end = i;
                int start = map.get(sum)+1;
                for(int j=start; j<=end; j++) System.out.print(arr[j] + " ");
                return true;
            }

            map.put(sum, i);
        }

        return false;
    }
}
