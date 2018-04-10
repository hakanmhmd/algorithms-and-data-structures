package Arrays;

/**
 * Count freq of each element in an array
 * O(n) time and O(1) space
 */
public class CountFrequencyOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {2,3,3,2,5};
        countFreq(arr);
    }

    private static void countFreq(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= 1;
        }

        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % n] += n;
        }

        // element at index i will be equal to arr[i] + n * k where k is the number of times it occurs in the array
        // dividing by n : (arr[i] + n*k)/n = arr[i]/n + k = 0+k
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i] / n;
            System.out.println(i+1 + " " + count);
            arr[i] = arr[i] % n + 1;
        }
    }
}
