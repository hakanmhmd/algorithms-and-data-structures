package Arrays;

/**
 * Largest sum of subelements in array
 */
public class LargestSubarraySum {
    private int[] elements;

    public LargestSubarraySum(int[] arr){
        this.elements = arr;
    }

    private void largestSum(){
//        int[] temp = new int[elements.length];
//        int max = elements[0];
//        temp[0] = elements[0];
//        System.out.print(temp[0] + " ");
//        for (int i = 1; i < elements.length; i++) {
//            temp[i] = Math.max(elements[i], temp[i - 1] + elements[i]);
//            max = Math.max(max, temp[i]);
//            System.out.print(temp[i] + " ");
//        }


        int largest = 0, largestSoFar = 0;
        int index = 0;
        for (int i = 0; i < elements.length; i++) {
            largestSoFar += elements[i];
            if(largestSoFar < 0) {
                largestSoFar = 0;
            }
            if(largestSoFar > largest) {
                largest = largestSoFar;
                index = i;
            }
        }


        System.out.println("Sum: " + largest);
    }

    private void maxSubArraySumNegative(int a[]) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        System.out.println(max_so_far);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -2};

        int[] arr2 = new int[]{-2, -3, -4, -1, -2, -1, -5, -3};
        LargestSubarraySum lss = new LargestSubarraySum(arr);
        lss.largestSum();
        lss.maxSubArraySumNegative(arr2);
    }
}
