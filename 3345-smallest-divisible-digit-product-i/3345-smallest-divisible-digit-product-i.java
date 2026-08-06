class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(true){
            int sum = 1;
            while(n>=1){
                int rem = n%10;
                sum*=rem;
                n = n/10;
            }
            if(sum%t == 0){
                return i;
            }
            i++;
            n = i;
        }
    }
}