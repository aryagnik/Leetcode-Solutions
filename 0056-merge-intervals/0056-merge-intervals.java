import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        int f = 0;

        for(int i=0; i<intervals.length; i++){
            if(l1.isEmpty() || intervals[i][0] > l1.get(f-1).get(1)){
                ArrayList<Integer> l2 = new ArrayList<>();

                l2.add(intervals[i][0]);
                l2.add(intervals[i][1]);

                l1.add(l2);

                f++;
            }
            else{
                f--;
                int ans = Math.max(l1.get(f).get(1),intervals[i][1]);

                l1.get(f).set(1,ans);
                f++;
            }
        }

        int[][] arr1 = new int[l1.size()][2];

        for(int i=0; i<l1.size(); i++){
            for(int j=0 ; j<2; j++){
                arr1[i][j] = l1.get(i).get(j);
            }
        }

        return arr1;

    }
}