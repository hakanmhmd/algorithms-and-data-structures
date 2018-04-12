package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 "1:34", "12:9" are all invalid.
 */
public class NextClosestTime {
    public static void main(String[] args) {
        String time = "23:59";
        System.out.println(closestTime(time));
    }

    private static String closestTime(String time) {
        int currTime = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        Set<Integer> allowedNums = new HashSet<>();
        for (char c : time.toCharArray()) {
            if(c != ':'){
                allowedNums.add(c - '0');
            }
        }

        while(true){
            currTime = (currTime + 1) % (24*60);
            int[] digits = {currTime/60/10, currTime/60%10, currTime%60/10, currTime%60%10};
            boolean flag = true;
            for(int d: digits){
                if(!allowedNums.contains(d)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return String.format("%02d:%02d", currTime / 60, currTime % 60);
        }
    }
}
