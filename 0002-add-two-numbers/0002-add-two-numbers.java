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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem =0;
        int res=0;
        int n1,n2=0;
        
        ListNode node = new ListNode();
        ListNode head = node;

        while(l1!=null || l2!=null){
            n1 = (l1 == null) ? 0 :l1.val;
            n2 = (l2 == null) ? 0 :l2.val;

            res = rem + n1 + n2;

            rem = res/10;
            res = res%10;

            node.next = new ListNode(res);         

            node = node.next;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }

        if (rem > 0) {
            node.next = new ListNode(rem);
        }

        return head.next;
    }
}