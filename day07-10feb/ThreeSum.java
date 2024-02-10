import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public static void selectionSort(int[] nums){
        for(int i = 0 ; i < nums.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[minIndex] ){
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        selectionSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i <nums.length - 2; i ++){
            int m = i+1;
            int e = nums.length -1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            while (m < e) {
                int cSum = nums[i] + nums[m] + nums[e];
                if(cSum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[m]);
                    temp.add(nums[e]);
                    result.add(temp);
                    break;
                } else if(cSum > 0){
                    e--;
                } else {
                    m++;
                }
                
                
            }
        }

        // while (s+1 !=m || m+1 != e) {
        //     int cSum = nums[s] + nums[m] + nums[e];
        //     if(cSum == 0){
        //         List<Integer> temp = new ArrayList<>();
        //         temp.add(nums[s]);
        //         temp.add(nums[m]);
        //         temp.add(nums[e]);
        //         result.add(temp);

        //         if(s < m){
        //             s++;
        //             while () {
        //                 s++;
        //             }
        //         }

        //     } else if(cSum > 0){
        //         if(e-1 == m){
        //             m--;
        //         } else{
        //             e--;
        //         }
        //     } else {
        //         if(m+1 == e){
        //             s++;
        //         } else {
        //             m++;
        //         }
        //     }
        // }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }
}
