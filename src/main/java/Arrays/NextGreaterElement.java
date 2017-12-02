package Arrays;

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
        printNGE(arr);
    }

    private static void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if(!stack.isEmpty()){
                Integer element = stack.pop();
                while(element < current){
                    System.out.println(element + " -> " + current);
                    if(stack.isEmpty()){
                        break;
                    }
                    element = stack.pop();
                }
                if(element > current){
                    stack.push(element);
                }
            }
            stack.push(current);
        }

        while(!stack.isEmpty()){
            Integer element = stack.pop();
            System.out.println(element + " -> null");
        }
    }
}
