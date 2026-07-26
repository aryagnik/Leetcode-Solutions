class Solution {
    public int maximumProduct(int[] nums) {
        ArrayList<Integer> l1 = new ArrayList<>();

        int neg_count = 0;
        int pos_count = 0;

        for(int i=0; i<nums.length; i++){
            l1.add(nums[i]);
            if(nums[i]<0)neg_count++;
            else if(nums[i]>0)pos_count++;
        }

        Collections.sort(l1);

        int n = l1.size();

        int ans = l1.get(n-1)*l1.get(n-2)*l1.get(n-3);
        
        if(pos_count == 1){
            return l1.get(n-1)*l1.get(0)*l1.get(1);
        }
        else if(neg_count == 1){
            if(pos_count == 2){
                return l1.get(0)*l1.get(1)*l1.get(2);
            }
            else{
                return ans;
            }
        }
        else if(pos_count == 2){
            return l1.get(0)*l1.get(1)*l1.get(n-1);
        }
        else if(pos_count >= 3){
            int ans1 = l1.get(0)*l1.get(1)*l1.get(n-1);
            if(ans1>ans){
                return ans1;
            }
            return ans;
        }
        else{
            return ans;
        }
    }
}