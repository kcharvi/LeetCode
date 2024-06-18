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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next == null)return head;
        ListNode temp = head;
        ListNode temp2 = head;
        int i=0;
        while(i<=left-2){
            temp = temp.next;
            temp2 = temp2.next;
            i++;
        }
        ArrayList<Integer> list = new ArrayList();
        int j=i;
        while(j<=right-1){
            list.add(temp2.val);
            temp2 = temp2.next;
            j++;
        }
        j=list.size()-1;
        while(i<=right-1 && j>=0){
            temp.val=list.get(j);
            temp=temp.next;
            j--;
            i++;
        }
        return head;
    }
}