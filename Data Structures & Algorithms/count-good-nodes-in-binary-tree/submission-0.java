/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int res=0;
        Queue<Pair<TreeNode,Integer>> q= new LinkedList<>();
        q.add(new Pair<>(root,Integer.MIN_VALUE));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> pair=q.poll();
                TreeNode node=pair.getKey();
                int value=pair.getValue();
                if(node.val >= value){
                    res++;
                }
                if(node.left!=null){
                    q.offer(new Pair<>(node.left, Math.max(value,node.val)));
                }
                if(node.right!=null){
                    q.offer(new Pair<>(node.right, Math.max(value,node.val)));
                }
            }
        }
        return res;
    }
}
