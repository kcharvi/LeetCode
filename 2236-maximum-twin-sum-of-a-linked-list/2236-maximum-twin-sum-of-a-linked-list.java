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
    public int pairSum(ListNode head) {
        //Base Condition

        //Reach the mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //Reverse second half
        ListNode prev = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //Traverse both while checking max sum
        int maxSum = 0;
        while(prev!=null && head!=null){
            maxSum = Math.max(maxSum, prev.val+head.val);
            prev = prev.next;
            head = head.next;
        }

        return maxSum;
    }
}