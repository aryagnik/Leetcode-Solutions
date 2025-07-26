class Solution {
    public boolean check(int[] nums) {
        int firstElem = nums[0];

        int flag = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                flag += 1;
            }
        }

        if (flag == 0) {
            return true;
        }

        if (flag == 1) {
            if (nums[nums.length - 1] <= nums[0]) {
                return true;
            }
        }
        return false;
    }
}