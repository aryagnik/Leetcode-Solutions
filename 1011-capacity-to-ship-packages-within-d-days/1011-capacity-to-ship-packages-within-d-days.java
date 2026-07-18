class Solution {
    public static int findMax(int[] arr){
        int max = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        return max;
    }

    public static int findSum(int[] arr){
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        return sum;
    }

    public static int findCapacity(int[] arr, int sum, int mid){
        int load = 0;
        int count = 1;

        for(int i=0; i<arr.length; i++){
            if(load + arr[i] > mid){
                count++;
                load = arr[i];
            }
            else{
                load += arr[i];
            }
        }

        return count;
    }

    public static int binary_search(int[] arr, int days, int max, int sum){
        int low = max;
        int high = sum;

        int ans = -1;

        while(low<=high){
            int mid = (low) + (high-low)/2;

            int count = findCapacity(arr,sum,mid);

            if(count<=days){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = findMax(weights);
        int sum = findSum(weights);

        return binary_search(weights,days,max,sum);
    }
}