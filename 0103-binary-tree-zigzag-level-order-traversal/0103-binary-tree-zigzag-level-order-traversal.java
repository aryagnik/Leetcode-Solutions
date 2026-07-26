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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l1 = new ArrayList<>();

        Queue<TreeNode> q1 = new LinkedList<>();

        if(root == null)return l1;

        q1.add(root);

        int count = 0;

        while(!(q1.isEmpty())){
            int size = q1.size();

            List<Integer> l2 = new ArrayList<>();

            for(int i=0; i<size; i++){
                root = q1.poll();

                if(root.left != null){
                    q1.add(root.left);
                }
                if(root.right != null){
                    q1.add(root.right);
                }

                l2.add(root.val);
            }

            count++;

            if(count % 2 == 0 && size > 1){
                ArrayList<Integer> l3 = new ArrayList<>();

                for(int i=l2.size()-1; i>=0; i--){
                    l3.add(l2.get(i));
                }

                l1.add(l3);
            }

            else{
                l1.add(l2);
            }
        }

        return l1;
    }
}