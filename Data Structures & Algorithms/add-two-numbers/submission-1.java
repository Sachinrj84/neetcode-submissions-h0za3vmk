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
        ListNode l1curr= l1;
        ListNode l2curr=l2;
        ListNode resNode= new ListNode(0);
        ListNode curr= resNode;
        int carry=0;
        while(l1curr != null || l2curr != null){
            int v1= l1curr != null ? l1curr.val:0;
            int v2= l2curr != null ? l2curr.val:0;
            int sum=v1+v2+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            if(l1curr!=null) l1curr=l1curr.next;
            if(l2curr!=null) l2curr=l2curr.next;
            curr=curr.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return resNode.next;
    }
}
