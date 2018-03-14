package Arrays;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class ArrayCycle {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 2};
        System.out.println(isCyclic(arr));

        arr = new int[]{-2,1,-1,-2,-2}; // {1, 2}
        System.out.println(isCycle(arr));
    }

    // each array element points to the index of the next element
    private static boolean isCyclic(int[] arr) {
        if(arr == null || arr.length == 0) return false;
        int fast = 0;
        int slow = 0;

        while(true){
            if(fast < 0 || slow < 0 || fast >= arr.length || slow >= arr.length){
                return false;
            }

            fast = arr[fast];
            if(fast == slow) return true;
            if(fast < 0 || fast >= arr.length){
                return false;
            }

            fast = arr[fast];
            if(fast == slow) return true;

            slow = arr[slow];
            if(fast == slow) return true;
        }
    }

    /*
    Given an array arr[0..n-1] of positive and negative numbers we need to find if there
    is a cycle in array with given rules of movements. If a number at an i
    index is positive, then move arr[i]%n forward steps, i.e., next index to
    visit is (i + arr[i])%n. Conversely, if it’s negative, move backward arr[i]%n
    steps i.e., next index to visit is (i – arr[i])%n. Here n is size of array. If value of arr[i]%n
    is zero, then it means no move from index i.
     */

    private static boolean isCycle(int[] arr){
        if(arr == null || arr.length == 0) return false;
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = (i+arr[i]+arr.length) % arr.length;
            if(i == temp[i]){
                temp[i] = Integer.MIN_VALUE;
            }
        }

        boolean[] visited = new boolean[arr.length];
        int index = 0;
        int[] parent = new int[arr.length];
        while(true){
            if(visited[index]){
                int val = index;
                int p = parent[index];
                int count = 0;
                while(val != p){
                    p = parent[p];
                    count++;
                }
                if(count > 1) return true;
                else return false;
            }
            visited[index] = true;
            if(temp[index] == Integer.MIN_VALUE) return false;
            parent[temp[index]] = index;
            index = temp[index];
        }
    }
}
