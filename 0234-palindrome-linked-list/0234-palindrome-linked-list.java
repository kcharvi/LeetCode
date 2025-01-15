/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next_ = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_;
        }
        ListNode left = head;
        ListNode right = prev;
        while(left!=null && right!=null){
            if(left.val!=right.val)return false;
            left = left.next;
            right = right.next;
        }
        return true;
         
    }
}