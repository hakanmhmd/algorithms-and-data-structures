package Sorting;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

/**
 * Given a string, sortCharsByFreq it in decreasing order based on the frequency of characters.
 * tree -> eetr/eert
 */
public class SortByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(sortCharsByFreq(s));

        int[] arr = {1,3,5,2,2,3,3,3,6,5};
        System.out.println(sortNumsByFreq(arr));
    }

    private static List<Integer> sortNumsByFreq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] countArr = new List[arr.length+1];
        for(Integer i: map.keySet()){
            int count = map.get(i);
            if(countArr[count] == null){
                countArr[count] = new ArrayList<>();
            }
            countArr[count].add(i);
        }
        List<Integer> res = new ArrayList<>();

        for (int i = countArr.length-1; i >= 0; i--) {
            if(countArr[i] != null) {
                res.addAll(countArr[i]);
            }
        }

        return res;
    }

    private static String sortCharsByFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] freqArr = new List[s.length()+1];

        for(Character c: map.keySet()){
            int count = map.get(c);
            if(freqArr[count] == null){
                freqArr[count] = new ArrayList<>();
            }
            freqArr[count].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=freqArr.length-1; i>=0; i--){
            List<Character> characters = freqArr[i];
            if(characters != null){
                for (Character character : characters) {
                    for(int j=0; j<i; j++) {
                        sb.append(character);
                    }
                }
            }
        }

        return sb.toString();
    }


}
