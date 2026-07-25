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
    public static int findAns(TreeNode root){
        if(root == null)return 0;
        else{
            return 1 + Math.max(findAns(root.left),findAns(root.right));
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        
        return findAns(root);
    }
}