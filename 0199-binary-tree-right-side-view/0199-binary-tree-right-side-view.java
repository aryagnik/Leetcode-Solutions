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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();

        Queue<TreeNode> q1 = new LinkedList<>();

        if(root == null)return l1;

        q1.add(root);

        while(!q1.isEmpty()){
            int size = q1.size();

            for(int i=0; i<size; i++){
                TreeNode root1 = q1.poll();

                if(i == (size-1)){
                    l1.add(root1.val);
                }

                if(root1.left != null){
                    q1.add(root1.left);
                }
                if(root1.right != null){
                    q1.add(root1.right);
                }
            }
        }

        return l1;
    }
}