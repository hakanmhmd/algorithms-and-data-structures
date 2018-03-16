package Arrays;

import java.util.List;

import java.util.ArrayList;

/**
 * [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {

    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> generate = generate(n);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }

        System.out.println();
        System.out.println(getRow(n));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 0) return result;

        result.add(1);
        for(int i=1; i<=rowIndex; i++){
            for(int j=result.size()-2; j>=0; j--){
                result.set(j+1, result.get(j) + result.get(j+1));
            }
            result.add(1);
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0)
            return result;

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);

        for(int i=2; i<=numRows; i++){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=0; j<pre.size()-1; j++){
                curr.add(pre.get(j) + pre.get(j+1));
            }
            curr.add(1);
            result.add(curr);
            pre = curr;
        }

        return result;
    }
}
