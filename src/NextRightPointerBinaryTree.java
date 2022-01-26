import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointerBinaryTree {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Node currNode;
        Queue<Node> fringe = new LinkedList<>();
        int nullTracker = 1, counter = 1;
        fringe.add(root);
        while (!fringe.isEmpty()) {
            currNode = fringe.poll();
            if (counter == nullTracker) {
                currNode.next = null;
                nullTracker = nullTracker + nullTracker*2;
            } else {
                currNode.next = fringe.peek();
            }
            if (null != currNode.left) {
                fringe.add(currNode.left);
                fringe.add(currNode.right);
            }
            counter++;
        }
        return root;
    }
}
