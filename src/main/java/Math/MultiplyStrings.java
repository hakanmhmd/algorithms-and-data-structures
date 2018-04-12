package Math;

/**
 * Multiply two strings
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String a = "112";
        String b = "12";

        System.out.println(mul(a, b));
    }

    private static String mul(String a, String b) {
        if (a == null || a.equals("0") || b == null || b.equals("0")) {
            return "0";
        }

        boolean isNegative = false;
        if(a.charAt(0) == '-') {
            isNegative = true;
            a = a.substring(1);
        }

        if(b.charAt(0) == '-'){
            isNegative ^= true;
            b = b.substring(1);
        }

        int[] res = new int[a.length() + b.length()];
        int end = res.length-1;
        int index = 0;
        for(int aInd = a.length()-1; aInd >=0; aInd--){
            int carry = 0;
            index = end;

            for(int bInd = b.length()-1; bInd >=0; bInd--){
                int curr = (a.charAt(aInd) - '0') * (b.charAt(bInd) - '0') + carry + res[index];
                res[index--] = curr % 10;
                carry = curr / 10;
            }

            if(carry > 0) res[index] = carry;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        if (isNegative) sb.append("-");

        if (res[index] == 0) index++;
        for (int i = index; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
