package Math;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 */
public class AddTwoStrings {
    public static void main(String[] args) {
        String str1 = "12349";
        String str2 = "98394";

        System.out.println(addStrings(str1, str2));
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || num2.equals("0")) {
            return num1;
        }

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            sb.insert(0, ((num1.charAt(i) - '0') + carry) % 10);
            carry = ((num1.charAt(i) - '0') + carry) / 10;
            i--;
        }

        while (j >= 0) {
            sb.insert(0, ((num2.charAt(j) - '0') + carry) % 10);
            carry = ((num2.charAt(j) - '0') + carry) / 10;
            j--;
        }

        if (carry == 1) sb.insert(0, carry);


        return sb.toString();
    }
}
