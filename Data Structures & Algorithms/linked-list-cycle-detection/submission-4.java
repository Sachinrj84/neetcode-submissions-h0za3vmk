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
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> store= new HashMap<>();
        while(head != null){
            if(store.containsKey(head)){
                return true;
            }
            store.put(head,0);
            head=head.next;
        }
        return false;
    }
}
