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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)return null;
        //Reach to the middle by tracking the previous of middle
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(prev.next !=slow)prev=prev.next;
        prev.next = slow.next;
        slow=null;
        return head;
    }
}