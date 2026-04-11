/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> store= new HashMap<>();
        store.put(null, null);
        Node curr= head;
        while(curr != null){
            Node copy= new Node(curr.val);
            store.put(curr, copy);
            curr=curr.next;
        }
        Node curr2= head;
        while(curr2 != null){
            Node getCopyNode= store.get(curr2);
            getCopyNode.next=store.get(curr2.next);
            getCopyNode.random=store.get(curr2.random);
            curr2=curr2.next;
        }
        return store.get(head);
    }
}
