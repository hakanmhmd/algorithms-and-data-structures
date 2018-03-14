package Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Max number of rows with 'P' after flipping k cols
 */
public class RowChangesMatrix {
    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        char[][] matrix = {
                {'P', 'P', 'T'},
                {'T', 'P', 'T'},
                {'T', 'T', 'T'}
        };

        int k = 2;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char[] row = matrix[i];
            int count = 0;

            for (char c : row)
                if (c == 'T') ++count;

            if (count == k || (k >= count && (k - count) % 2 != 0)) {
                String key = new String(row);
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key, 1);
            }
        }

        System.out.println(Collections.max(map.values()));
    }

    private String getComplement(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            builder.append(string.charAt(i) == 'a' ? 'b' : 'a');
        }
        return builder.toString();
    }

    /**
     * Solves the problem for the matrix.
     */
    public int getMaxRows(String[] matrix) {
        Map<String, Integer> count = new HashMap<>();
        for (String row : matrix) {
            count.put(row, count.getOrDefault(row, 0) + 1);
            String complement = getComplement(row);
            count.put(complement, count.getOrDefault(complement, 0) + 1);
        }
        return Collections.max(count.values());
    }
}
