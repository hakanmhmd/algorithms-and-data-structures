package Tree;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/balanced-forest/problem
 * DFS/BFS
 * <p>
 * Sample input:
 * 1
 * 8
 * 1 1 1 18 10 11 5 6
 * 1 2
 * 1 4
 * 2 3
 * 1 8
 * 8 7
 * 6 7
 * 5 7
 */
public class BalancedForest {
    static class Node {
        int coins;
        int name;
        ArrayList<Node> children;

        public Node(int name, int coins) {
            this.name = name;
            this.coins = coins;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            Node[] nodes = new Node[n];
            long[] S = new long[n];
            for (int j = 0; j < n; j++) {
                nodes[j] = new Node(j, in.nextInt());
                S[0] += nodes[j].coins;
            }

            for (int j = 0; j < n - 1; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                nodes[x - 1].children.add(nodes[y - 1]);
                nodes[y - 1].children.add(nodes[x - 1]);
            }

            populateS(nodes, S);

            long answer = -1;
            for (int j = 1; j < nodes.length - 1; j++) {
                for (int k = j + 1; k < nodes.length; k++) {
                    Node X = nodes[j];
                    Node Y = nodes[k];

                    if (lca(nodes[0], X, Y) == X) {
                        //x ancestor of y
                        int firstComponentSum = (int) (S[0] - S[j]);
                        int secondComponentSum = (int) (S[j] - S[k]);
                        int thirdComponentSum = (int) S[k];
                        answer = updateAnswer(answer, firstComponentSum, secondComponentSum, thirdComponentSum);
                    } else if (lca(nodes[0], X, Y) == Y) {
                        //y ancestor of x
                        int firstComponentSum = (int) (S[0] - S[k]);
                        int secondComponentSum = (int) (S[k] - S[j]);
                        int thirdComponentSum = (int) S[j];
                        answer = updateAnswer(answer, firstComponentSum, secondComponentSum, thirdComponentSum);
                    } else {
                        //x and y are not related
                        int firstComponentSum = (int) (S[0] - S[j] - S[k]);
                        int secondComponentSum = (int) S[j];
                        int thirdComponentSum = (int) S[k];
                        answer = updateAnswer(answer, firstComponentSum, secondComponentSum, thirdComponentSum);
                    }
                }
            }
            System.out.println(answer);

        }
        in.close();
    }

    private static long updateAnswer(long answer, int firstComponentSum, int secondComponentSum, int thirdComponentSum) {
        long majority = -1;
        if (firstComponentSum == secondComponentSum) {
            majority = firstComponentSum;
        }
        if (firstComponentSum == thirdComponentSum) {
            majority = firstComponentSum;
        }
        if (secondComponentSum == thirdComponentSum) {
            majority = secondComponentSum;
        }

        if (majority != -1) {
            long other = firstComponentSum ^ secondComponentSum ^ thirdComponentSum;
            if (other <= majority) {
                if (answer == -1) {
                    answer = majority - other;
                } else {
                    answer = Math.min(answer, majority - other);
                }
            }
        }
        return answer;
    }

    private static Node lca(Node root, Node x, Node y) {
        Stack<Node> ancestorsOfX = pathTo(root, x);
        Stack<Node> ancestorOfY = pathTo(root, y);

        Node lca = null;
        while (!ancestorOfY.isEmpty() && !ancestorsOfX.isEmpty()) {
            Node xPop = ancestorsOfX.pop();
            Node yPop = ancestorOfY.pop();

            if (xPop == yPop) {
                lca = xPop;
            } else {
                break;
            }
        }
        return lca;
    }

    private static Stack<Node> pathTo(Node root, Node x) {
        if (root == null) return null;
        if (root == x) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            return stack;
        }

        ArrayList<Node> children = root.children;
        for (Node c : children) {
            Stack<Node> path = pathTo(c, x);
            if (path != null) {
                path.add(root);
                return path;
            }
        }

        return null;
    }

    private static void populateS(Node[] nodes, long[] S) {
        //Node cloned = cloneGraph(nodes[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(nodes[0]);
        while (!q.isEmpty()) {
            Node parent = q.remove();
            for (Node c : parent.children) {
                c.children.remove(parent);
                long sum = recursiveDFS(c, new boolean[nodes.length]);
                S[c.name] = sum;
                q.add(c);
            }
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map =
                new HashMap<>();

        Node newHead = new Node(node.name, node.coins);

        queue.add(node);
        map.put(node, newHead);

        while (!queue.isEmpty()) {
            Node curr = queue.pop();
            ArrayList<Node> currNeighbors = curr.children;

            for (Node aNeighbor : currNeighbors) {
                if (!map.containsKey(aNeighbor)) {
                    Node copy = new Node(aNeighbor.name, aNeighbor.coins);
                    map.put(aNeighbor, copy);
                    map.get(curr).children.add(copy);
                    queue.add(aNeighbor);
                } else {
                    map.get(curr).children.add(map.get(aNeighbor));
                }
            }

        }
        return newHead;
    }

    public static ArrayList<Long> dfs(Node[] nodes) {
        boolean[] visited = new boolean[nodes.length];
        ArrayList<Long> componentSums = new ArrayList<>();
        componentSums.add(recursiveDFS(nodes[0], visited));

        for (int i = 0; i < nodes.length; i++) {
            if (!visited[nodes[i].name]) {
                componentSums.add(recursiveDFS(nodes[i], visited));
            }
        }

        return componentSums;

    }

    public static long recursiveDFS(Node n, boolean[] visited) {
        visited[n.name] = true;
        long sum = n.coins;
        for (Node c : n.children) {
            if (!visited[c.name]) {
                sum += recursiveDFS(c, visited);
            }
        }

        return sum;
    }
}
