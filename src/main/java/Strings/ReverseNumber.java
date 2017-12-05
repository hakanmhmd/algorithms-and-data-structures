package Strings;

/**
 * Created by hakanmehmed on 03/12/2017.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverseNumber(num));
    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        while(num!=0){
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
