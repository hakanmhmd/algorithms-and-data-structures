package Graph;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that only one letter can be changed at a time and
 * each intermediate word must exist in the dictionary.
 */
public class WordLadder {
    private static class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        if(!set.contains(end)) System.out.println(0);
        else {
            System.out.println(ladderLength(start, end, set));
        }
    }

    private static int ladderLength(String start, String end, Set<String> set) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));

        set.add(end);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            if(word.equals(end)) return top.numSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    arr[i] = c;

                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        set.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }

    // Word ladder 2 - print path of all shortest routes
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }



}
