class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx1 = 0;
        int idx2 = matrix[0].length-1;

        while(idx1<matrix.length && idx2>=0){
            int mid = matrix[idx1][idx2];

            if(mid == target){
                return true;
            }
            else if(mid < target){
                idx1++;
            }
            else{
                idx2--;
            }
        }

        return false;
    }
}