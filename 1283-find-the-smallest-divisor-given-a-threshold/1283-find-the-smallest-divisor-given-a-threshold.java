class Solution {

    public static int findMax(int[] nums){
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>max)max = nums[i];
        }

        return max;
    }

    public static int findAns(int[] arr, int max, int k){
        int low = 1;
        int high = max;

        int ans = 0;

        while(low<=high){
            int mid = (low) + (high-low)/2;

            long sum = 0;

            for(int i=0; i<arr.length; i++){
                sum += (arr[i] + mid - 1)/mid;
            }

            System.out.println(mid+","+sum);

            if(sum <= k){
                ans = mid;
                System.out.println(ans);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = findMax(nums);

        int ans = findAns(nums,max,threshold);

        return ans;
    }
}