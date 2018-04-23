package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class MissingRanges {
    public static void main(String[] args) {
        int[] arr = {3,50,51,52,75, 98};

        System.out.println(missingRanges(0, 100, arr));
        System.out.println(summaryRanges(arr));
    }

    private static ArrayList<String> missingRanges(int start, int end, int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        if(arr == null) return res;
        if(arr.length == 0) {
            res.add("0->99");
            return res;
        }


        int prev = start-1;
        for(int i=0; i<arr.length; i++){
            int current = arr[i];
            int diff = current-prev-1;
            if(diff != 0){
                if(diff == 1){
                    res.add("" + (prev+1));
                } else {
                    res.add((prev+1) + "->" + (current-1));
                }
            }
            prev = current;
        }

        int current = end;


        int diff = current-prev-1;
        if(diff != 0){
            if(diff == 1){
                res.add("" + (prev+1));
            } else {
                res.add((prev+1) + "->" + (current-1));
            }
        }
        return res;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
}
