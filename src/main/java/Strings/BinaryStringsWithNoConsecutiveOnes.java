package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hakanmehmed on 19/03/2018.
 */
public class BinaryStringsWithNoConsecutiveOnes {
    public static void main(String[] args) {
        int len = 3;
        List<String> list = generateStrings(3);
        System.out.println(list);
    }

    private static List<String> generateStrings(int n) {
        List<String> endingWithZero = new ArrayList<>();
        List<String> endingWithOne = new ArrayList<>();

        endingWithZero.add("0");
        endingWithOne.add("1");

        for(int i=1; i<n; i++){
            List<String> zeroTemp = new ArrayList<>();
            List<String> oneTemp = new ArrayList<>();

            for(String s: endingWithZero){
                oneTemp.add(s + "1");
                zeroTemp.add(s + "0");
            }
            for(String s: endingWithOne){
                zeroTemp.add(s + "0");
            }
            endingWithZero = zeroTemp;
            endingWithOne = oneTemp;

        }

        endingWithOne.addAll(endingWithZero);
        return endingWithOne;
    }
}
