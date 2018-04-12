package Arrays;

import java.util.ArrayList;

/**
 * A majority element in an array of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element).
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 5, 2, 6, 2, 2, 5};

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

        System.out.println("Maj n/3 = " + majorityElement3(arr));

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

    // O(n) runtime, O(1) space Moore's voting algorithm
    private static int findMajorityElementCandidate(int[] arr) {
        /**
         *   int candidate = arr[0], count = 1;
             for (int i = 1; i < arr.length; i++) {
             if(count == 0){
             candidate = arr[i];
             count = 1;
             } else {
             if(candidate == arr[i]) count++;
             else count--;
             }
             }
             return candidate;
         */
        int maj_index = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[maj_index] == arr[i]){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                // change the index to the current element's index
                maj_index = i;
                // reset the count
                count = 1;
            }
        }
        return arr[maj_index];
    }

    //Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    // The algorithm should run in linear time and in O(1) space.
    // There can only be 2 elements with count > n/3 so keep two counters (same as Boyer-Moore voting algorithm)
    public static ArrayList<Integer> majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;

    }
}
