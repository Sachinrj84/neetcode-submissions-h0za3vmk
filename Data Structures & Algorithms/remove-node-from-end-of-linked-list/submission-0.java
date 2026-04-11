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
        ListNode temp= new ListNode(0);
        temp.next=head;
        ListNode curr=temp;
        ListNode slow= head;
        ListNode fast= head;
        for(int i=0; i<n;i++){
            fast=fast.next;
        }
        while(fast != null){
            curr=curr.next;
            slow=slow.next;
            fast=fast.next;
        }
        curr.next=slow.next;
        return temp.next;
    }
}
