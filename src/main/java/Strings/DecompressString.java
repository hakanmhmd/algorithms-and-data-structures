package Strings;

import java.util.Objects;
import java.util.Stack;

/**
 * Decompress string - string (s) followed by {n} denotes s repeating n times
 "a(b(c){2}){2}d" decompresses to "abccbccd"
 "((x){3}(y){2}z){2}" decompresses to "xxxyyzxxxyyz"
 */
public class DecompressString {
    public static void main(String[] args) {
        String s = "a(b(c){2}){2}d";
        System.out.println(decompress(s));
    }

    private static String decompress(String s) {
        Stack<String> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != ')' && c != '}'){
                stack.push(Character.toString(c));
            } else if(c == ')'){
                String temp = stack.pop();
                StringBuilder sb = new StringBuilder();
                while(!Objects.equals(temp, "(")){
                    sb.insert(0, temp);
                    temp = stack.pop();
                }
                stack.push(sb.toString());
            } else {
                String temp = stack.pop();
                StringBuilder sb = new StringBuilder();
                while(!Objects.equals(temp, "{")){
                    sb.insert(0, temp);
                    temp = stack.pop();
                }
                int count = Integer.parseInt(sb.toString());
                String str = stack.pop();
                sb = new StringBuilder();
                for(int i=0; i<count; i++){
                    sb.append(str);
                }
                stack.push(sb.toString());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
