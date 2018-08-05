package Tree;

/**
 * Implement locking in a binary tree. A binary tree node can be locked or unlocked only
 * if all of its descendants or ancestors are not locked.

 Design a binary tree node class with the following methods:

 is_locked, which returns whether the node is locked
 lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise,
 it should lock it and return true.
 unlock, which unlocks the node. If it cannot be unlocked, then it should return false.
 Otherwise, it should unlock it and return true.

 */
public class LockingBinaryTree {
    static class Node {
        int val;
        Node right;
        Node left;
        Node parent;
        boolean isLocked;
        int lockedChildren;

        public Node(int data){
            this.val = data;
            right = null;
            left = null;
            parent = null;
            isLocked = false;
            lockedChildren = 0;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        two.parent = one;

        one.left.left = four;
        four.parent = two;

        one.right = three;
        three.parent = one;

        one.right.left = five;
        five.parent = three;

        one.right.right = six;
        six.parent = three;

        one.right.left.left = seven;
        seven.parent = five;

        lock(five);
        System.out.println(isLocked(five));
        lock(one);
        System.out.println(isLocked(one));
        lock(three);
        System.out.println(isLocked(three));
        lock(seven);

        unlock(five);
        unlock(one);
    }

    private static boolean canLockOrUnlock(Node node){
        if(node.lockedChildren > 0) return false;
        Node curr = node.parent;
        while(curr != null){
            if(curr.isLocked){
                return false;
            }
            curr = curr.parent;
        }
        return true;
    }

    private static boolean unlock(Node node) {
        if(canLockOrUnlock(node)){
            node.isLocked = false;
            Node curr = node.parent;
            while(curr != null){
                curr.lockedChildren -= 1;
                curr = curr.parent;
            }
            return true;
        }
        System.out.println("Cant unlock node " + node.val);
        return false;
    }

    private static boolean isLocked(Node node) {
        return node.isLocked;
    }

    private static boolean lock(Node node) {
        if(canLockOrUnlock(node)){
            node.isLocked = true;
            Node curr = node.parent;
            while(curr != null){
                curr.lockedChildren += 1;
                curr = curr.parent;
            }
            return true;
        }
        System.out.println("Cant lock node " + node.val);
        return false;
    }
}
