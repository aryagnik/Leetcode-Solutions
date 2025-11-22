class Solution {
    public static int reverse(ArrayList<Character> l1, int left, int right){
        if(left >= right){
            return 1;
        }
        else{
            if(l1.get(left) == l1.get(right)){
                return reverse(l1,left+1,right-1);
            }
            else{
                return 0;
            }
        }
    }
    public boolean isPalindrome(String s) {
        ArrayList<Character> l1 = new ArrayList<>();

        for(char ch: s.toCharArray()){
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                ch = Character.toLowerCase(ch);
                l1.add(ch);
            }
        }

        int ans = reverse(l1,0,l1.size()-1);

        if(ans == 1){
            return true;
        }
        else{
            return false;
        }
    }
}