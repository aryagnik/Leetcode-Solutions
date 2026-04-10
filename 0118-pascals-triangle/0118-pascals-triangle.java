class Solution {
    public List<List<Integer>> generate(int numRows) {
        int rows = numRows;

        List<List<Integer>> mainList = new ArrayList<>();

        for(int i=1; i<=rows; i++){
            List<Integer> l1 = new ArrayList<>();
            int ans = 1;

            for(int j=0; j<i; j++){
                if(j == 0){
                    l1.add(1);
                    continue;
                }
                else{
                    ans = ans*(i-j);
                    ans = ans/(j);
                }
                l1.add(ans);
            }
            mainList.add(l1);
        }

        return mainList;
    }
}