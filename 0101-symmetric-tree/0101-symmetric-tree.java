/**
 * Definition for a binary tree TreeNode.
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();

        q1.add(root);

        while(!q1.isEmpty()){
            int size = q1.size();
            ArrayList<Integer> l1 = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode root1 = q1.poll();

                if(root1 == null){
                    l1.add(null);
                    continue;
                }
                else{
                    l1.add(root1.val);
                    q1.add(root1.left);
                    q1.add(root1.right);
                }
            }

            int i = 0;
            int j = l1.size()-1;

            while(i<=j){
                if(l1.get(i) != l1.get(j)){
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}