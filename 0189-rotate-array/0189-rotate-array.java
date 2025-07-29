class Solution {
    public static void reverse(int[] arr, int a, int b){
        while(a<=b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k%n;

        if(n==1){
            return;
        }
        if(k == n){
            return;
        }

        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
}