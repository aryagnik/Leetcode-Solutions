class Solution {

    static int count = 0;

    public static void MergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;

            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            count_pairs(arr,low,mid,high);
            Merge(arr,low,mid,high);
        }
    }

    public static void Merge(int[] arr, int low, int mid, int high){
        int[] arr1 = new int[high-low+1];

        int i = low, j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                arr1[k] = arr[i];
                k++;
                i++;
            }
            else{
                arr1[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i<=mid){
            arr1[k] = arr[i];
            k++;
            i++;
        }

        while(j<=high){
            arr1[k] = arr[j];
            k++;
            j++;
        }

        for(i=0; i<arr1.length; i++){
            arr[low+i] = arr1[i];
        }
    }

    public static void count_pairs(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;

        for(int i=low; i<=mid; i++){
            while(right <= high && (long)arr[i] > 2L*arr[right]){
                right++;
            }

            count += (right - (mid+1));
        }
    }

    public int reversePairs(int[] nums) {
        count = 0;

        System.out.println(nums.length);

        MergeSort(nums,0,nums.length-1);

        return count;
    }
}