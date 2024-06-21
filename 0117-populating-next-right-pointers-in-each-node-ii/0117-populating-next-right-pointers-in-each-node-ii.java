/*
// Definition for a Node.
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
};
*/

class Solution {
    public Node connect(Node root) {   
        if (root == null) return null;
        Node currentLevelStart = root;
        
        while (currentLevelStart != null) {
            Node current = currentLevelStart;
            Node nextLevelStart = null;
            Node prev = null;
            
            while (current != null) {
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        nextLevelStart = current.left;
                    }
                    prev = current.left;
                }

                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        nextLevelStart = current.right;
                    }
                    prev = current.right;
                }

                current = current.next;
            }
            
            currentLevelStart = nextLevelStart;
        }
        
        return root;
    }
}