package Graph;

import java.util.*;

/**
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 */
public class OrderOfCharacters {
    public static void main(String[] args) {
        String words[] = {"x", "z", "x"};
        printOrder(words);
    }

    private static void printOrder(String[] words) {
        int n = words.length;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        // Process all adjacent pairs of words and create a graph
        for(int i=0; i<n-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    if(graph.containsKey(word1.charAt(j)-'a')){
                        graph.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');
                    } else {
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(word2.charAt(j)-'a');
                        graph.put(word1.charAt(j)-'a', al);
                    }
                }
            }
        }

        topologicalSort(graph);

    }

    private static void topologicalSort(HashMap<Integer, ArrayList<Integer>> graph) {
        Set<Integer> V = graph.keySet();
        boolean isCyclic = true;
        for(Integer node: V){
            if(graph.get(node).size() == 0){
                isCyclic = false;
                break;
            }
        }
        if(isCyclic){
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack();

        for(Integer node: V){
            if(!visited.contains(node)){
                util(graph, node, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            System.out.println((char)('a'+ pop));
        }

    }

    private static void util(HashMap<Integer, ArrayList<Integer>> graph, Integer i, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(i);
        ArrayList<Integer> n = graph.get(i);
        if(n!= null) {
            for (Integer neighbour : n) {
                if (!visited.contains(neighbour)) {
                    util(graph, neighbour, visited, stack);
                }
            }
        }

        stack.push(i);
    }
}
