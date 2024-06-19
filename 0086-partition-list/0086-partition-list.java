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
    public ListNode partition(ListNode head, int x) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x)
              list1.add(temp.val);
            else
              list2.add(temp.val);

            temp = temp.next;
        }

        temp = head;
        int i=0;
        int j=0;
        while(temp != null){
            if(i < list1.size()){
                temp.val = list1.get(i);
                i++;
            }
            else if(j < list2.size()){
                temp.val = list2.get(j);
                j++;
            }

            temp = temp.next;
        }
        return head;
    }
}