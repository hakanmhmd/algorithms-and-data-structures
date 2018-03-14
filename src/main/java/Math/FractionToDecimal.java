package Math;

import java.util.HashMap;

/**
 * Created by hakanmehmed on 13/03/2018.
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "Invalid";

        String result = "";

        if((numerator < 0) ^ (denominator < 0)){
            result+="-";
        }

        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);

        long q = num / denom;
        result += q;

        long rem = (num % denom) * 10;
        if(rem == 0){
            return result;
        }
        result += ".";
        // rem to position
        HashMap<Long, Integer> map = new HashMap<>();
        while(rem != 0){
            if(map.containsKey(rem)){
                // found repeating
                int pos = map.get(rem);
                String part1 = result.substring(0, pos);
                String part2 = result.substring(pos);
                result = part1 + "(" + part2 + ")";
                return result;
            }

            map.put(rem, result.length());
            q = rem / denom;
            result += q;
            rem = (rem % denom) * 10;
        }
        return result;
    }
}
