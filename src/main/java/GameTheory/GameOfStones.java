package GameTheory;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
 * minimax, alpha beta pruning
 * memoization - bottomup
 */
public class GameOfStones {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(input.nextLine());

            int alpha = Integer.MIN_VALUE;
            int beta = Integer.MAX_VALUE;
            if (minimax(n, alpha, beta, true) == -1) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }

            //String[] mem = new String[n+1];
            //Arrays.fill(mem, "");
            //System.out.println(findWinner(n, mem));
        }
    }


    private static int[] possibleMoves = {5, 3, 2};

    private static int minimax(int n, int alpha, int beta, boolean max) {
        // leaf node
        if (n == 1) {
            if (max) return -1;
            else return 1;
        }
        if (n <= 6) {
            if (max) return 1;
            else return -1;
        }
        int bestValue;
        if (max) {
            bestValue = Integer.MIN_VALUE;
            for (int move : possibleMoves) {
                if (n - move >= 0) {
                    int result = minimax(n - move, alpha, beta, false);
                    if (result > bestValue) {
                        bestValue = result;
                    }
                    alpha = Math.max(alpha, bestValue);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }

        } else {
            bestValue = Integer.MAX_VALUE;
            for (int move : possibleMoves) {
                if (n - move >= 0) {
                    int result = minimax(n - move, alpha, beta, true);
                    if (result < bestValue) {
                        bestValue = result;
                    }
                    beta = Math.min(beta, bestValue);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
        }


        return bestValue;
    }

    private static String findWinner(int n, String[] mem) {
        if (n == 1) {
            return "Second";
        }
        if (n <= 6) {
            return "First";
        } else {
            if (mem[n] == "") {
                String winnerOf5 = findWinner(n - 5, mem);
                String winnerOf3 = findWinner(n - 3, mem);
                String winnerOf2 = findWinner(n - 2, mem);
                if (winnerOf2 == "First" && winnerOf3 == "First" && winnerOf5 == "First") {
                    mem[n] = "Second";
                } else {
                    mem[n] = "First";
                }
            }
            return mem[n];
        }
    }
}
