import java.util.ArrayList;
import java.util.Arrays;

class MergeIntervals{

    public static int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> result = new ArrayList<>();
        
        if(intervals.length == 0){
            result.add(new int[]{});
        } else if(intervals.length == 0){
            result.add(new int[]{intervals[0][0],intervals[0][1]});
        } else {
            int cs, ce;
            int ls = intervals[0][0]; 
            int le = intervals[0][1]; 

            int i = 1;
            while (i < intervals.length) {
                cs = intervals[i][0];
                ce = intervals[i][1];

                if(cs <= le){
                    le = ce;
                    i++;
                } else{
                    result.add(new int[]{ls,le});
                    ls = cs;
                    le = ce;
                    i++;
                }
            }
            result.add(new int[]{ls,le});
        }

        int[][] resultArray = new int[result.size()][];
        result.toArray(resultArray);

        return resultArray;

    }
    
    public static void sort(int[][] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j< nums.length - 1 - i; j++){
                if(nums[j][0] > nums[j + 1][0]){
                    int[] temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums= {{1,4},{0,0}};
        sort(nums);

        System.out.println(Arrays.deepToString(nums));
        int[][] result = merge(nums);

        System.out.println(Arrays.deepToString(result));
    }
}