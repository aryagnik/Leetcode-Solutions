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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l2 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();

        if(root == null)return l2;

        q1.add(root);
        l1.add(root.val);
        l2.add(l1);

        while(!(q1.isEmpty())){
            int size = q1.size();
            l1 = new ArrayList<>();

            for(int i=0; i<size; i++){
                root = q1.poll();

                if(root.left != null){
                    q1.add(root.left);
                    l1.add(root.left.val);
                }
                if(root.right != null){
                    q1.add(root.right);
                    l1.add(root.right.val);
                }
            }

            l2.add(l1);
        }

        l2.remove(l2.size()-1);

        return l2;
    }
}