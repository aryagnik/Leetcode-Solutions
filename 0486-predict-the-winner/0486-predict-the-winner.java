class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return helper(nums, 0, n - 1, dp) >= 0;
    }

    private int helper(int[] nums, int i, int j, int[][] dp) {
        if (i == j) return nums[i];
        if (dp[i][j] != 0) return dp[i][j];

        int pickLeft = nums[i] - helper(nums, i + 1, j, dp);
        int pickRight = nums[j] - helper(nums, i, j - 1, dp);

        dp[i][j] = Math.max(pickLeft, pickRight);
        return dp[i][j];
    }
}
