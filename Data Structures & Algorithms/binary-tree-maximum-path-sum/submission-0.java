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
    public int maxPathSum(TreeNode root) {
        res=root.val;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftmax=dfs(root.left);
        int rightmax=dfs(root.right);
        leftmax=Math.max(leftmax,0);
        rightmax=Math.max(rightmax,0);
        res=Math.max(res,(root.val+leftmax+rightmax));
        return root.val+Math.max(leftmax,rightmax);
    }
}
