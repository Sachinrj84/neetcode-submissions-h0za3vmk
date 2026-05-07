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
        int ans=dfs(root, Integer.MIN_VALUE);
        return ans;
    }
    public int dfs(TreeNode root, int maxval){
        if(root==null) return 0;
        
        res= res+(root.val>=maxval?1:0);
        maxval=Math.max(root.val,maxval);
        dfs(root.left,maxval);
        dfs(root.right,maxval);
        return res;
    }
}
