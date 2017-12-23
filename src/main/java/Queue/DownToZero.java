package Queue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/down-to-zero-ii/problem
 */
public class DownToZero {
    static class QueueNode {
        int num;
        int d;

        public QueueNode(int num, int d){
            this.num =num;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int N = in.nextInt();
            findMinMoves(N);
        }
    }

    //DP solution
    static int[] memo = new int[1000001]; // N is 10^6 max
    private static int findMinMovesDP(int N) {
        if(N <= 3){
            return N;
        }
        if(memo[N] != 0) {
            return memo[N];
        }
        int min = Integer.MAX_VALUE;
        for(int i=2; i<=Math.sqrt(N); i++){
            if(N % i == 0){
                min = Math.min(min, 1+findMinMovesDP(N/i));
            }
        }
        min = Math.min(min, 1+findMinMovesDP(N-1));
        memo[N] = min;
        return min;

    }

    // BFS solution
    private static void findMinMoves(int N) {
        Queue<QueueNode> q = new LinkedList<>();
        q.add(new QueueNode(N, 0));
        while(!q.isEmpty()){
            QueueNode w = q.remove();
            int num = w.num;
            int d = w.d;
            if(num <= 4){
                if(num == 4){
                    System.out.println(d + 3);
                } else {
                    System.out.println(d + num);
                }
                break;
            }
            q.add(new QueueNode(num-1, d+1));
            for(int i=2; i<=Math.sqrt(num); i++){
                if(num % i == 0){
                    q.add(new QueueNode(Math.max(i, num/i), d+1));
                }
            }

        }
    }
}
