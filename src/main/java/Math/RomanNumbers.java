package Math;

/**
 * Convert between roman and arabic numbers
 */
public class RomanNumbers {
    public static void main(String[] args) {
        int result = romanToInt("MDCCCLXXXIV");
        System.out.println(result);
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
