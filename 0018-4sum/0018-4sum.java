import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> l2 = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
            for(int j=i+1; j<nums.length; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int m = j+1;
                int n = nums.length-1;

                while(m<n){
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];

                    if(sum == target){

                        System.out.println("YEs");
                        List<Integer> l1 = new ArrayList<>();

                        l1.add(nums[i]);
                        l1.add(nums[j]);
                        l1.add(nums[m]);
                        l1.add(nums[n]);

                        // Collections.sort(l1);

                        l2.add(l1);

                        m++;
                        n--;

                        while(m<n && nums[m-1] == nums[m])m++;
                        while(m<n && nums[n] == nums[n+1])n--;
                    }

                    else if(sum < target){
                        m++;
                    }

                    else{
                        n--;
                    }
                }
            }
        }

        return l2;
    }
}