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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        ArrayList<Integer> l1 = new ArrayList<>();

        TreeNode prev = null;

        while(root != null || !(st1.isEmpty())){
            while(root != null){
                st1.push(root);
                root = root.left;
            }

            root = st1.peek();

            if(root.right != null && root.right != prev){
                root = root.right;
            }
            else{
                System.out.println("yes");
                l1.add(root.val);
                st1.pop();
                prev = root;
                root = null;
            }
        }

        return l1;
    }
}