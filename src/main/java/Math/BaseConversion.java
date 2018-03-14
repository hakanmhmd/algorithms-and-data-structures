package Math;

import org.junit.Assert;

/**
 * Created by hakanmehmed on 09/03/2018.
 */
public class BaseConversion {
    private static final char[] digits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U'
    };

    public static void main(String[] args) {
        int num = 23412342;
        int base = 32;
        String expected = "MAFJM";

        Assert.assertEquals(expected, convert(num, base));
    }

    private static String convert(int num, int base) {
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            int temp = num % base;
            sb.append(digits[temp]);
            num /= base;
        }

        return sb.reverse().toString();
    }
}
