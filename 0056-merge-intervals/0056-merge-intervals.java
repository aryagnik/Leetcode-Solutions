import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            else{
                return a[0]-b[0];
            }
        });

        for(int i=0; i<intervals.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(intervals[i][j]);
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();

        int prevStart = -1, prevEnd = -1;

        int f = 0;

        // System.out.println(intervals.length);

        for(int i=0; i<intervals.length; i++){
            
            int start = intervals[i][0];
            int end = intervals[i][1];

            System.out.print(start);
            System.out.println(end);

            if(i == 0){
                ArrayList<Integer> l2 = new ArrayList<>();

                l2.add(start);
                l2.add(end);

                l1.add(l2);

                prevStart = start;
                prevEnd = end;
                f++;
            }
            else{

                if(start <= prevEnd){
                    if(end <= prevEnd){
                        continue;
                    }
                    else{
                        f--;
                        l1.remove(f);
                        ArrayList<Integer> l2 = new ArrayList<>();

                        l2.add(prevStart);
                        l2.add(end);

                        l1.add(l2);
                        f++;

                        prevStart = prevStart;
                        prevEnd = end;
                    }
                }
                else{
                    ArrayList<Integer> l2 = new ArrayList<>();

                    System.out.println("YES");

                    l2.add(start);
                    l2.add(end);

                    l1.add(l2);
                    f++;

                    prevStart = start;
                    prevEnd = end;
                }
            }
        }

        System.out.println(l1);

        int[][] arr = new int[l1.size()][2];

        for(int i=0; i<l1.size(); i++){
            for(int j=0; j<2; j++){
                arr[i][j] = l1.get(i).get(j);
            }
        }

        return arr;
    }
}