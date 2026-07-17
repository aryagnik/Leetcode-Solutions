class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        int n = nums.length;

        while(low<=high){
            if(low == high){
                return nums[low];
            }

            int mid = (low) + (high-low)/2;

            if(mid>=1 && nums[mid-1] == nums[mid]){
                if((n-mid) % 2 != 0){
                    high = mid-2;
                }
                else{
                    low = mid+1;
                }
            }

            else if(mid<=n-2 && nums[mid+1] == nums[mid]){
                if((n-mid) % 2 == 0){
                    high = mid-1;
                }
                else{
                    low = mid+2;
                }
            }

            else{
                return nums[mid];
            }
        }
        return 1;
    }
}