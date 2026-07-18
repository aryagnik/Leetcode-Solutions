class Solution {

    public static int[] findMax(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for(int i=1; i<arr.length; i++){
            if(max<arr[i])max = arr[i];
            if(min>arr[i])min = arr[i];
        }

        return new int[] {min,max};
    }

    public static int binary_search(int[] arr, int m, int k, int min, int max){
        int low = min;
        int high = max;

        int ans = -1;

        while(low<=high){
            int count = 0;
            int mid = (low)+(high-low)/2;
            int m1 = m;

            for(int i=0; i<arr.length; i++){
                if(arr[i]<=mid){
                    count++;
                    if(count == k){
                    m1-=1;
                    count = 0;
                }
                    if(m1 == 0){
                    break;
                }
                }
                else{
                    count = 0;
                }
            }

            if(m1 == 0){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }

        int[] arr1 = findMax(bloomDay);

        int min = arr1[0];
        int max = arr1[1];

        int ans = binary_search(bloomDay,m,k,min,max);

        return ans;
    }
}