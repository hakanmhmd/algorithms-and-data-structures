package Arrays;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
 */
public class NextGreaterElement {
    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 8, 9, 14, 21, 3, 2, 1 };
        findNGE(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void findNGE(int[] arr) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // pair (number, index)
        stack.push(new Pair<>(arr[0], 0));


        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            while(!stack.isEmpty() && stack.peek().fst < current){
                Pair<Integer, Integer> top = stack.pop();
                arr[top.snd] = current;
            }
            stack.push(new Pair<>(current, i));
        }

        while(!stack.isEmpty()){
            Pair<Integer, Integer> element = stack.pop();
            arr[element.snd] = -1;
        }
    }
}
