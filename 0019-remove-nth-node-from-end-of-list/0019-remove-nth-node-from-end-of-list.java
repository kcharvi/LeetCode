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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0)return head;
        if(head.next ==null && n==1)return null;
        int size=0;
        ListNode dummy=head;
        while(dummy!=null){
            dummy = dummy.next;
            size++;
        }
        if (size == n) {
            return head.next;
        }
        int i=1;
        ListNode temp=head;
        while(size-n>i){
            temp=temp.next;
            i++;
        }
        temp.next = temp.next.next;
        

        return head;
    }
}