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

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> s= new ArrayList<>();
        dfs(root,s);
        String str=String.join(",",s);
        System.out.println("String:"+str);
        return str;
    }
    public void dfs(TreeNode root, List<String> s){
        if(root==null){
            s.add("N");
            return;
        }
        s.add(String.valueOf(root.val));
        dfs(root.left,s);
        dfs(root.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values= data.split(",");
        int[] i={0};
        return deserial(values,i);
    }
    public TreeNode deserial(String[] values, int[] i){
        if(values[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(values[i[0]]));
        i[0]++;
        root.left=deserial(values,i);
        root.right=deserial(values,i);
        return root;
    }
}
