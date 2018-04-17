package Graph;

import java.util.*;

/**
 * Given a source word, target word and an English dictionary, transform the source word to target
 * by changing/adding/removing 1 character at a time, while all intermediate words being valid
 * English words. Return the transformation chain which has the smallest number of intermediate words.
 */
public class TransformWord {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("cat", "bat", "at", "bed", "bet", "ed", "ad"));
        Map<String, Set<String>> graph = constructGraph(dict);

        for (String s : graph.keySet()) {
            System.out.println(s + ": " + graph.get(s));
        }

        String start = "cat";
        String end = "bed";
        transformWord(graph, start, end);

    }

    //bfs search
    private static void transformWord(Map<String, Set<String>> graph, String start, String end) {
        ArrayList<String> path = new ArrayList<>();
        path.add(start);
        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.add(path);

        while(!queue.isEmpty()){
            ArrayList<String> currentPath = queue.poll();
            String word = currentPath.get(currentPath.size()-1);
            if(word.equals(end)) {
                System.out.println(currentPath);
            }

            Set<String> transformations = graph.get(word);
            for(String t : transformations){
                if(!currentPath.contains(t)){
                    ArrayList<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(t);
                    queue.add(newPath);
                }
            }
        }

    }

    private static Map<String, Set<String>> constructGraph(Set<String> dict) {
        Map<String, Set<String>> map = new HashMap<>();

        for(String word: dict){
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                //remove one char
                //char temp = arr[i];
                //arr[i] = '';
                String remove = word.substring(0, i) + word.substring(i+1, word.length());
                if(dict.contains(remove)){
                    populate(map, word, remove);
                }

                //change one char
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    arr[i] = c;
                    String change = new String(arr);
                    if(!word.equals(change) && dict.contains(change)){
                        populate(map, word, change);
                    }
                    arr[i] = temp;
                }
            }

            //add one char
            for(int i=0; i<arr.length+1; i++){
                for(char c='a'; c<='z'; c++){
                    String add = word.substring(0, i) + Character.toString(c) + word.substring(i, word.length());
                    if(dict.contains(add)){
                        populate(map, word, add);
                    }
                }
            }
        }

        return map;
    }

    private static void populate(Map<String, Set<String>> map, String word, String add) {
        Set<String> strings = map.get(word);
        if(strings == null) {
            strings = new HashSet<>();
            map.put(word, strings);
        }
        strings.add(add);
    }


}
