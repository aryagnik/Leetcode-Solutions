class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;

        int row = rowIndex;

        List<Integer> l1 = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++){
            if(i==0 || i==(rowIndex)){
                l1.add(1);
                continue;
            }
            else{
                ans = ans*(row);
                ans = ans/(i);
                row--;
                l1.add((int)ans);
            }
        }

        return l1;
    }
}