package Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an unsorted array with repetitions, the task is to group multiple
 * occurrence of individual elements. The grouping should happen in a way
 * that the order of first occurrences of all elements is maintained.
 */
public class GroupArrayElements {
    public static void main(String[] args) {
        int[] input = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4};
        System.out.println(Arrays.toString(groupElements(input)));
    }

    public static int[] groupElements(int[] input){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }
        }
        int[] result = new int[input.length];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            Integer count = map.get(input[i]);
            if(count != null) {
                for (int j = 0; j < count; j++) {
                    result[index++] = input[i];
                }
            }
            map.remove(input[i]);
        }

        return result;
    }
}
