package Math;

import java.util.HashMap;

/**
 * Created by hakanmehmed on 27/02/2018.
 */
public class IntToEnglish {
    static HashMap<Integer, String> map = new HashMap<Integer, String>();
    public static void main(String[] args) {
        int num = 2050132343;
        fill();
        String convert = translate(num);
        System.out.println(convert);
    }

    static String translate(int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0) return map.get(0);

        if(num >= 1000000000){
            int div = num / 1000000000;
            sb.append(convert(div)).append(" billion");
            num %= 1000000000;
        }

        if(num >= 1000000){
            int div = num / 1000000;
            sb.append(convert(div)).append(" million");
            num %= 1000000;
        }

        if(num >= 1000){
            int div = num / 1000;
            sb.append(convert(div)).append(" thousand");
            num %= 1000;
        }

        if(num > 0) sb.append(convert(num));

        return sb.toString();

    }

    private static String convert(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 100){
            int div = num / 100;
            sb.append(" ").append(map.get(div)).append(" hundred");
            num %= 100;
        }
        if(num > 0){
            if(num <= 20){
                sb.append(" ").append(map.get(num));
            } else {
                int tens = num / 10;
                sb.append(" ").append(map.get(tens * 10));
                num %= 10;
                if(num > 0){
                    sb.append(" ").append(map.get(num));
                }
            }
        }

        return sb.toString();
    }

    public static void fill(){
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
}
