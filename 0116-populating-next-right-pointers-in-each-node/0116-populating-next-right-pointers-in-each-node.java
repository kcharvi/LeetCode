class Solution {
    public Node connect(Node root) {   
        if (root == null) return null;
        
        Node curr = root;
        
        while (curr != null && curr.left != null) {
            Node temp = curr;
            
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            
            curr = curr.left;
        }
        
        return root;
    }
}