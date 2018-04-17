package Recursion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Print all "symmetric" numbers with a given number of  digits. These are numbers that read the same upside down.
 *
 * n = 2 -> 11, 88, 69, 96, 66, 99
 */
public class FindSymmetricNumbers {
    static HashMap<Character, Character> map = new HashMap<Character,Character>();

    public static void main(String[] args) {
        int n = 2;
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        System.out.println(findNums(n));
    }

    private static ArrayList<Integer> findNums(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if(n == 0) return res;
        char[] arr = new char[n];
        recurse(res, arr, 0, arr.length-1);
        return res;
    }

    private static void recurse(ArrayList<Integer> res, char[] arr, int s, int e) {
        if(s > e){
            res.add(Integer.parseInt(new String(arr)));
            return;
        }
        if(s == e){
            // only one element - 8, 1, 0 (6,9 are not symmetric on their own)
            arr[s] = '8';
            res.add(Integer.parseInt(new String(arr)));
            arr[s] = '1';
            res.add(Integer.parseInt(new String(arr)));
            arr[s] = '0';
            res.add(Integer.parseInt(new String(arr)));

            return;
        }

        arr[s] = '1';
        arr[e] = '1';
        recurse(res, arr, s+1, e-1);
        arr[s] = '8';
        arr[e] = '8';
        recurse(res, arr, s+1, e-1);
        arr[s] = '6';
        arr[e] = '6';
        recurse(res, arr, s+1, e-1);
        arr[s] = '9';
        arr[e] = '9';
        recurse(res, arr, s+1, e-1);
        arr[s] = '6';
        arr[e] = '9';
        recurse(res, arr, s+1, e-1);
        arr[s] = '9';
        arr[e] = '6';
        recurse(res, arr, s+1, e-1);
    }
}
