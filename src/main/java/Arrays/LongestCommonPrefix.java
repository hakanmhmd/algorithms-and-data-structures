package Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 If there is no common prefix, return an empty string ""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(prefix(arr));
    }

    private static String prefix(String[] arr) {
        if (arr == null || arr.length == 0) return "";
        for(int i=0; i<arr[0].length(); i++){
            char ch = arr[0].charAt(i);
            for(int j=1; j<arr.length; j++){
                if(i == arr[j].length() || arr[j].charAt(i) != ch){
                    return arr[0].substring(0, i);
                }
            }
        }

        return arr[0];
    }
}
