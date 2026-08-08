/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;

        if(root == p || root == q)return root;

        TreeNode root1 = lowestCommonAncestor(root.left,p,q);
        TreeNode root2 = lowestCommonAncestor(root.right,p,q);

        if((root1 == null) && (root2 == null))
            return null;
        else if(root1 == null)
            return root2;
        else if(root2 == null)
            return root1;
        else
            return root;
    }
}