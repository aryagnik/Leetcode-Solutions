class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low)+(high-low)/2;

            int idx = arr[mid]-(mid+1);

            if(idx<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return low+k;
    }
}