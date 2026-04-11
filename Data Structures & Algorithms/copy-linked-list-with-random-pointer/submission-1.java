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
        HashMap<Node, Node> copyList= new HashMap<>();
        copyList.put(null, null);
        Node cur= head;
        while(cur != null){
            if(!copyList.containsKey(cur)){
                copyList.put(cur, new Node(0));
            }
            copyList.get(cur).val=cur.val;
            if(!copyList.containsKey(cur.next)){
                copyList.put(cur.next, new Node(0));
            }
            copyList.get(cur).next=copyList.get(cur.next);
            if(!copyList.containsKey(cur.random)){
                copyList.put(cur.random, new Node(0));
            }
            copyList.get(cur).random= copyList.get(cur.random);
            cur=cur.next;
        }
            return copyList.get(head);
    }
}
