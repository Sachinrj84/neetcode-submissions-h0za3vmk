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
    int res=0;
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int maxValue){
        if(root==null){
            return 0;
        }
        res= res+(root.val>=maxValue?1:0);
        maxValue=Math.max(root.val,maxValue);
        dfs(root.left,maxValue);
        dfs(root.right,maxValue);
        return res;
    }
}
