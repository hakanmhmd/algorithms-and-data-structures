package Arrays;

/**
 * A majority element in an array of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element).
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 5, 2, 6, 2};

        // First method
        int candidate = findMajorityElementCandidate(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate) {
                count++;
            }
        }
        if(count > arr.length/2){
            System.out.println(candidate);
        } else {
            System.out.println("No majority.");
        }

        // Second method
        int majority = findMajorite(arr);
        if(majority != -1){
            System.out.println(majority);
        } else {
            System.out.println("No majority.");
        }

    }

    // O(n) runtime, O(1) space
    private static int findMajorityElementCandidate(int[] arr) {
        int size = arr.length;
        int index = 0, count = 1;
        for (int i = 1; i < size; i++) {
            if(arr[index] == arr[i]){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                // change the index to the current element's index
                index = i;
                // reset the count
                count = 1;
            }
        }
        return arr[index];
    }

    // O(n) time, O(n+k) space where k is the biggest element
    private static int findMajorite(int[] arr){
        int size = arr.length;
        int biggest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > biggest){
                biggest = arr[i];
            }
        }
        int[] helperArr = new int[biggest+1];
        for (int i = 0; i < arr.length; i++) {
            int count = helperArr[arr[i]];
            int newCount = count + 1;
            if(newCount > size/2){
                return arr[i];
            }
            helperArr[arr[i]] = newCount;
        }
        return -1;
    }
}
