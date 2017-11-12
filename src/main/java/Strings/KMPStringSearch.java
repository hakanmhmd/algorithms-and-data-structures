package Strings;

/**
 * Created by hakanmehmed on 19/10/2017.
 */
public class KMPStringSearch {
    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMPStringSearch ss = new KMPStringSearch();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }

    private int[] computeHelperArray(char pattern[]){
        int[] array = new int[pattern.length];
        array[0] = 0;
        int i=1;
        int j=0;

        while(i < pattern.length){
            if(pattern[i] == pattern[j]){
                array[i++] = j+1;
                j++;
            } else {
                if(j != 0){
                    j = array[j-1];
                } else {
                    array[i++] = 0;
                }
            }
        }
        return array;
    }

    private boolean KMP(char[] text, char[] pattern) {
        int[] helperArray = computeHelperArray(pattern);
        int i=0;
        int j=0;

        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            } else {
                if(j!=0){
                    j = helperArray[j-1];
                } else {
                    i++;
                }
            }
        }

        if(j == pattern.length){
            return true;
        }

        return false;
    }
}
