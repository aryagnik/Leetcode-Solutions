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

class Tuple{
    int row;
    int col;
    TreeNode root;

    public Tuple(int row, int col, TreeNode root){
        this.row = row;
        this.col = col;
        this.root = root;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm1 = new TreeMap<>();

        if(root == null)return ans;

        Queue<Tuple> queue = new LinkedList<>();
        int row = 0;
        int col = 0;

        queue.add(new Tuple(row,col,root));

        while(!(queue.isEmpty())){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Tuple curr = queue.poll();
                
                int row1 = curr.row;
                int col1 = curr.col;
                TreeNode root1 = curr.root;

                if(tm1.containsKey(col1)){
                    if(tm1.get(col1).containsKey(row1)){
                        tm1.get(col1).get(row1).offer(root1.val);
                    }
                    else{
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.offer(root1.val);
                        tm1.get(col1).put(row1,pq);
                    }
                }
                else{
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(root1.val);
                    tm1.put(col1,new TreeMap<>());
                    tm1.get(col1).put(row1,pq);
                }

                if(root1.left != null){
                    queue.add(new Tuple(row1+1,col1-1,root1.left));
                }
                if(root1.right != null){
                    queue.add(new Tuple(row1+1,col1+1,root1.right));
                }
            }
        }

        for(int i: tm1.keySet()){
            List<Integer> l2 = new ArrayList<>();
            for(int j: tm1.get(i).keySet()){
                PriorityQueue<Integer> pq1 = tm1.get(i).get(j);

                while(!(pq1.isEmpty())){
                    l2.add(pq1.poll());
                }
            }
            ans.add(l2);
        }

        return ans;


    }
}