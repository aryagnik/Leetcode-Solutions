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
    public static boolean findPath(TreeNode root, int target, ArrayList<TreeNode> l1){
        if(root == null)return false;

        if(root.val == target){
            l1.add(root);
            return true;
        }

        if(findPath(root.left,target,l1)){
            l1.add(root);
            return true;
        }

        if(findPath(root.right,target,l1)){
            l1.add(root);
            return true;
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> l1 = new ArrayList<>();
        ArrayList<TreeNode> l2 = new ArrayList<>();

        findPath(root,p.val,l1);
        findPath(root,q.val,l2);

        for(TreeNode i:l1){
            if(l2.contains(i)){
                return i;
            }
        }

        return root;
    }
}