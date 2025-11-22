class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        else{
            int num = 0;
            int y = x;

            while(x>0){
                int rem = x%10;
                num = num*10 + rem;
                x = x/10;
            }

            if(num == y){
                return true;
            }
            return false;
        }
    }
}