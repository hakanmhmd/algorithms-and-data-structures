package Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write
 * a function to compute the researcher's h-index. According to the definition of h-index on
 * Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 */
public class HIndex {
    public static void main(String[] args) {
        int[] c = {3, 0, 6, 1, 5};
        System.out.println(hIndex(c));
    }

    public static int hIndex(int[] citations) {
        int[] arr = new int[citations.length+1];

        for(int i=0; i<citations.length; i++){
            if(citations[i] >= citations.length) arr[citations.length]++;
            else arr[citations[i]]++;
        }

        int total = 0;
        for(int i=citations.length; i>=0; i--){
            total += arr[i];
            if(total >= i) return i;
        }
        return 0;
    }
}
