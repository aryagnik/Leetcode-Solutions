class Solution {

    public static int[] findMax(int[] nums){
        int min = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]<min)min = nums[1];
            if(nums[i]>max)max = nums[i];
        }

        return new int[]{min,max};
    }

    public static int findAns(int[] arr, int min, int max, int k){
        int low = 1;
        int high = max;

        int ans = 0;

        while(low<=high){
            int mid = (low) + (high-low)/2;

            int sum = 0;

            for(int i=0; i<arr.length; i++){
                sum += Math.ceil((double)arr[i]/(double)mid);
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
        int[] arr1 = findMax(nums);

        int min = arr1[0];
        int max = arr1[1];

        int ans = findAns(nums,min,max,threshold);

        return ans;
    }
}