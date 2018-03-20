package Arrays;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "bcacab";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    //Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;
        s = s.toLowerCase();
        while(i < j){
            if(Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            } else {
                if(!Character.isLetterOrDigit(s.charAt(i))){
                    i++;
                }
                if(!Character.isLetterOrDigit(s.charAt(j))){
                    j--;
                }
            }
        }

        return true;
    }
}
