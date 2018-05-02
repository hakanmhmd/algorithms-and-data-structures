package Strings;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters
 * are at least distance k from each other.

 All input strings are given in lowercase letters. If it is not possible to
 rearrange the string, return an empty string "".
 */
public class RearrangeStringKDistanceApart {
    static class Char {
        char ch;
        int count;

        Char(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        String s = "aaabc";
        int k = 3;
        System.out.println(rearrange(s, k));
    }

    private static String rearrange(String s, int k) {
        PriorityQueue<Char> queue = new PriorityQueue<>((c1, c2) -> c2.count - c1.count);
        int[] map = new int[26];
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(map[i] > 0){
                queue.offer(new Char((char)(i+'a'), map[i]));
            }
        }

        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            int i = 0;
            ArrayList<Char> temp = new ArrayList<>();

            while(i<k){
                if(!queue.isEmpty()){
                    Char ch = queue.poll();
                    if(ch.count > 1){
                        temp.add(ch);
                        ch.count--;
                    }
                    res.append(ch.ch);
                } else {
                    return "";
                }
                i++;
            }

            for(Char c: temp){
                queue.offer(c);
            }
        }

        return res.toString();
    }
}
