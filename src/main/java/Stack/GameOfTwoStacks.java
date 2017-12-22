package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 */
public class GameOfTwoStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            Stack<Integer> A = new Stack<>();
            for(int i=a.length-1; i>=0; i--){
                A.push(a[i]);
            }

            Stack<Integer> B = new Stack<>();
            for(int i=b.length-1; i>=0; i--){
                B.push(b[i]);
            }
            HashMap<String, Integer> map = new HashMap<>();
            System.out.println(findMaxScore(A, B, x));
        }
    }

    private static int findMaxScore(Stack<Integer> A, Stack<Integer> B, int maxSum){
        int runningSum = 0;
        Stack<Integer> tempA = new Stack<>();
        Stack<Integer> tempB = new Stack<>();

        int Amoves = 0;
        int Bmoves = 0;
        while(!A.isEmpty() && runningSum + A.peek() <= maxSum){
            int pop = A.pop();
            tempA.push(pop);
            runningSum += pop;
            Amoves++;
        }

        int result = Amoves;
        while(!B.isEmpty()){
            int pop = B.pop();
            tempB.push(pop);
            runningSum += pop;
            Bmoves++;

            while(runningSum > maxSum && !tempA.isEmpty()){
                runningSum -= tempA.peek();
                A.push(tempA.pop());
                Amoves--;
            }

            if(runningSum <= maxSum && result < Amoves + Bmoves){
                result = Amoves + Bmoves;
            }

        }

        return result;
    }

    // Dynamic programming solution
    private static int findMaxScore(Stack<Integer> A, Stack<Integer> B, int currentSum, int maxSum, HashMap<String, Integer> m){
        String h = hash(A, B);
        if(m.containsKey(h)){
            return m.get(h);
        }
        int scoreA = 0;
        int scoreB = 0;
        if(!A.isEmpty()){
            int val = A.pop();
            if(currentSum + val > maxSum){
                scoreA = 0;
            } else {
                scoreA = findMaxScore(A, B, currentSum + val, maxSum, m) + 1;
            }
            A.push(val);
        }

        if(!B.isEmpty()){
            int val = B.pop();
            if(currentSum + val > maxSum){
                scoreB = 0;
            } else {
                scoreB = findMaxScore(A, B, currentSum + val, maxSum, m) + 1;
            }
            B.push(val);
        }

        int max = Math.max(scoreA, scoreB);
        m.put(h, max);
        return max;
    }

    public static String hash(Stack<Integer> s1, Stack<Integer> s2) {
        StringBuilder hash = new StringBuilder();
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        while(!s1.isEmpty()) {
            int n = s1.pop();
            temp1.push(n);
            hash.append(n);
        }

        while(!s2.isEmpty()) {
            int n = s2.pop();
            temp2.push(n);
            hash.append(n);
        }

        while(!temp1.isEmpty()) {
            s1.push(temp1.pop());
        }
        while(!temp2.isEmpty()) {
            s2.push(temp2.pop());
        }

        return hash.toString();
    }
}
