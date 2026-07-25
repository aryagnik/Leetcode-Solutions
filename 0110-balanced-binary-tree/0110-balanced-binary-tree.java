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
    public static int findHeight(TreeNode root){
        if(root != null){
            int leftHeight = findHeight(root.left);
            if(leftHeight == -1)return -1;

            int rightHeight = findHeight(root.right);
            if(rightHeight == -1)return -1;

            if(Math.abs(leftHeight - rightHeight) > 1)return -1;

            return 1 + Math.max(leftHeight,rightHeight);
        }

        return 0;
    }
    public boolean isBalanced(TreeNode root) {
        int ans = findHeight(root);

        if(ans == -1){
            return false;
        }
        return true;
    }
}