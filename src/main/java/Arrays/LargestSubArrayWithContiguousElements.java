package Arrays;

/**
 * Created by hakanmehmed on 02/03/2018.
 */
public class LargestSubArrayWithContiguousElements {
    public static void main(String[] args) {
        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};

        System.out.println(findLength(arr));
    }

    private static int findLength(int[] arr) {
        int maxLen = 1;
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int max = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > max) max = arr[j];
                if(arr[j] < min) min = arr[j];

                if(j-i == max-min){
                    maxLen = Math.max(maxLen, max-min+1);
                }
            }
        }

        return maxLen;
    }
}
