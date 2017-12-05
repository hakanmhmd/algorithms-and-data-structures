package Arrays;

/**
 * Created by hakanmehmed on 03/12/2017.
 */
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40, 50},
            {15, 25, 35, 45, 50},
            {27, 29, 37, 49, 50},
            {32, 33, 39, 50, 52},
        };
        System.out.println(search(arr, 49));
    }

    private static boolean search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        int i = 0;
        int j = cols-1;
        while(i < rows && j >= 0){
            int element = arr[i][j];
            if(element == target) {
                return true;
            }
            if(element > target){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
