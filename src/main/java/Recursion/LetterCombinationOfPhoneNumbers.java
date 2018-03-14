package Recursion;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class LetterCombinationOfPhoneNumbers {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        ArrayList<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return result;

        ArrayList<Character> temp = new ArrayList<>();
        getString(digits, temp, result, map);

        return result;
    }

    private static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result, HashMap<Integer, String> map) {
        if(digits.length() == 0){
            char[] arr = new char[temp.size()];
            for(int i=0; i<arr.length; i++){
                arr[i] = temp.get(i);
            }
            result.add(new String(arr));
            return;
        }

        Integer num = Integer.valueOf(digits.substring(0,1));
        String letters = map.get(num);

        for(int i=0; i<letters.length(); i++){
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.remove(temp.size()-1);
        }
    }
}
