package Math;

/**
 * Convert between roman and arabic numbers
 */
public class RomanNumbers {
    public static void main(String[] args) {
        int result = romanToInt("MDCCCLXXXIV");
        System.out.println(result);
        System.out.println(intToRoman(result));
    }
    public static int romanToInt(String s) {
        int result = 0;
        int i=0;
        while(i < s.length()){
            int num = letterToNum(s.charAt(i));

            i++;
            if(i == s.length()) {
                result += num;
                break;
            }

            int nextNum = letterToNum(s.charAt(i));
            if(nextNum > num){
                result += (nextNum - num);
                i++;
            } else {
                result += num;
            }
        }

        return result;
    }

    static String intToRoman(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static int letterToNum(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
