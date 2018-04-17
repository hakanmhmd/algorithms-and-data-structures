package Stack;

import java.util.Stack;

/**
 * Given a file system find the longest absolute path
 */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";

        System.out.println(longestPath(s));
    }

    private static int longestPath(String s) {
        String[] split = s.split("\n");
        Stack<Integer> stack = new Stack<>();
        int currentLen = 0;
        int maxLen = 0;
        for(String str : split){
            int level = findLevel(str);

            while(stack.size() > level){
                currentLen -= stack.pop();
            }

            int len = str.replaceAll("\t", "").length()+1;
            currentLen += len;

            if(str.contains(".")){
                // file
                maxLen = Math.max(maxLen, currentLen-1);
            }
            stack.push(len);
        }

        return maxLen;
    }

    private static int findLevel(String s) {
        String replace = s.replaceAll("\t", "");
        int diff = s.length() - replace.length();
        return diff;
    }
}
