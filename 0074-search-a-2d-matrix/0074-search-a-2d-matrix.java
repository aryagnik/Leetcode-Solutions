class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low1 = 0;
        int high1 = matrix.length-1;

        int low2 = 0;
        int high2 = matrix[0].length-1;

        while(low1<=high1 && low2<=high2){
            int mid1 = (low1)+(high1-low1)/2;
            int mid2 = (low2)+(high2-low2)/2;

            if(matrix[mid1][mid2] == target){
                return true;
            }
            else if(matrix[mid1][mid2] < target){
                if(matrix[mid1][high2] < target){
                    low1 = mid1+1;
                }
                else{
                    low2 = mid2+1;
                }
            }
            else{
                if(matrix[mid1][low2] > target){
                    high1 = mid1-1;
                }
                else{
                    high2 = mid2-1;
                }
            }
        }

        return false;
    }
}