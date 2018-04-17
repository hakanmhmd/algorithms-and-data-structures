package Math;


/**
 * Given a number, find the next smallest palindrome larger than the number.
 * For example if the number is 125, next smallest palindrome is 131.
 */
public class NextPalindromeNumber {
    public static void main(String[] args) {
        System.out.println(findNextPalindrome(125));
        System.out.println(findNextPalindrome(1997));
        System.out.println(findNextPalindrome(4512));
    }

    private static int findNextPalindrome(int n) {
        char[] arr = Integer.toString(n).toCharArray();

        int middle = arr[(arr.length-1)/2];

        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            arr[right] = arr[left];
            left++;
            right--;
        }

        int incrementValue = 0;
        if(arr.length % 2 == 0){
            incrementValue = (int) (1.1 * Math.pow(10, arr.length/2));
        } else {
            incrementValue = (int) Math.pow(10, arr.length/2);
        }

        int newNum = Integer.parseInt(new String(arr));
        if(newNum >= n) return newNum;

        if (middle != '9') {
            return newNum+incrementValue;
        }

        return findNextPalindrome(roundUp(n));
    }

    private static int roundUp(int n) {
        int length = ("" + n).length();
        int increment = (int) Math.pow(10,((length/2)+1));
        return ((n/increment)+1)*increment;
    }
}
