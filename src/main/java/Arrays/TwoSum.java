package Arrays;

import java.util.ArrayList;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add(input) – Add the number input to an internal data structure.

 find(value) – Find if there exists any pair of numbers which sum is equal to the value.

 For example, add(1); add(3); add(5); find(4)->true; find(7)->false


 add – O(n) runtime, find – O(1) runtime, O(n2) space– Store pair sums in hash table: We could store all possible pair
 sums into a hash table. The extra space needed is in the order of O(n2). You would also need an extra O(n)
 space to store the list of added numbers. Each add operation essentially go through the list and form new pair
 sums that go into the hash table. The find operation involves a single hash table lookup in O(1) runtime.
 This method is useful if the number of find operations far exceeds the number of add operations.


 add – O(log n) runtime, find – O(n) runtime, O(n) space – Binary search + Two pointers: Maintain a sorted array
 of numbers. Each add operation would need O(log n) time to insert it at the correct position using a modified
 binary search (See Question [48. Search Insert Position]). For find operation we could then apply the [Two pointers]
 approach in O(n) runtime.


 add – O(1) runtime, find – O(n) runtime, O(n) space – Store input in hash table: A simpler approach is to
 store each input into a hash table. To find if a pair sum exists, just iterate through the hash table
 in O(n) runtime. Make sure you are able to handle duplicates correctly.
 */
public class TwoSum {
    ArrayList<Integer> sortedArr = new ArrayList<>();

    void add(int input){
        insertSorted(input);
        System.out.println(sortedArr);
    }

    private void insertSorted(int input) {
        if(sortedArr.isEmpty()){
            sortedArr.add(input);
            return;
        }

        int left = 0;
        int right = sortedArr.size()-1;

        while(left <= right){
            int mid = (left+right)/2;
            if(input == sortedArr.get(mid)){
                sortedArr.add(mid, input);
                return;
            } else if(input > sortedArr.get(mid)){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        sortedArr.add(left, input);
    }

    boolean find(int target){
        int left = 0;
        int right = sortedArr.size()-1;

        while(left < right){
            int sum = sortedArr.get(left) + sortedArr.get(right);
            if(sum == target) {
                return true;
            } else if(sum > target){
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(5);
        ts.add(4);
        ts.add(2);
        System.out.println(ts.find(4));
        System.out.println(ts.find(7));
        System.out.println(ts.find(8));
    }
}
