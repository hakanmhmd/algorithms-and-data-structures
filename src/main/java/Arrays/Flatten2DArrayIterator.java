package Arrays;

/**
 * Implement an iterator to flatten a 2d vector.
 */
public class Flatten2DArrayIterator {
    static class FlattenIterator {
        int rows;
        int[][] vec2d;
        int r;
        int c;
        public FlattenIterator(int[][] arr){
            vec2d = arr;
            rows = arr.length;
            r = 0;
            c = 0;
        }

        public boolean hasNext() {
            while(r < rows && (vec2d[r] == null || vec2d[r].length == 0)){
                r++;
            }

            return vec2d != null && vec2d.length != 0 && r < rows;
        }

        public int next() {
            int ans = 0;
            if(c < vec2d[r].length){
                ans = vec2d[r][c];
            }

            c++;
            if(c == vec2d[r].length){
                r++;
                c=0;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3},
                null,
                {},
                {4,5,6},
                {},
                {}
        };

        FlattenIterator fi = new FlattenIterator(arr);
        while(fi.hasNext()){
            System.out.println(fi.next());
        }
    }
}
