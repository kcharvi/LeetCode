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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            countMap.put(temp.val, countMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        temp = head;

        while (temp != null) {
            if (countMap.get(temp.val) > 1) {
                prev.next = temp.next; 
            } else {
                prev = temp;
            }
            temp = temp.next; // Move to the next node
        }
        return dummy.next;
    }
}