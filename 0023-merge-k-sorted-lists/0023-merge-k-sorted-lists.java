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
    public ListNode mergeKLists(ListNode[] lists) {
        //Fill the HashMap
        HashMap<Integer, Integer> unsortedMap = new HashMap();
        for(ListNode l : lists){
            while(l!=null){
                unsortedMap.put(l.val, unsortedMap.getOrDefault(l.val, 0) + 1);
                l=l.next;
            }
        }

        //Sorting the HashMap by keys
        ArrayList<Integer> arrList = new ArrayList<>(unsortedMap.keySet());
        Collections.sort(arrList);
        
        //Create the ListNode
        ListNode ans = new ListNode();
        ListNode node = ans;
        for(Integer key : arrList){
            for(int i = 0; i<unsortedMap.get(key); i++){
                node.next = new ListNode(key);
                node = node.next;
            }
        }
        return ans.next;
    }
}