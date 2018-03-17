package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd".
 *
 */
public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "acef", "yza", "az", "ba", "a", "z"};

        List<List<String>> grouped = groupStrings(strs);
        System.out.println(grouped);
    }

    private static List<List<String>> groupStrings(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for (String str : strs) {
            if(str == null || str.length() == 0) continue;

            StringBuilder key = new StringBuilder();
            int diff = str.charAt(0) - 'a';
            for (char c : str.toCharArray()){
                if(c-diff<'a'){
                    key.append((char)(c-diff+26));
                }else{
                    key.append((char)(c-diff));
                }

            }

            if(map.containsKey(key.toString())){
                map.get(key.toString()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key.toString(), list);
            }
        }

        for(String key: map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}
