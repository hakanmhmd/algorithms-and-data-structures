package Arrays;

/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words,
 * find how many times the given sentence can be fitted on the screen.
 */
public class SentenceScreenFitting {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 6;
        String[] arr = {"a", "bcd", "e"};

        System.out.println(fit(rows, cols, arr));
    }

    private static int fit(int rows, int cols, String[] arr) {
        int count = 0;
        int index = 0;
        int r = 0;
        int c = 0;

        String word = arr[index];
        while(r < rows){
            if(c + word.length() < cols){
                c += word.length()+1;
                index++;
                if(index == arr.length) {
                    count++;
                    index = 0;
                }
            } else {
                r++;
                c = 0;
            }
            if(c >= cols-2){
                r++;
                c=0;
            }
        }

        return count;
    }
}
