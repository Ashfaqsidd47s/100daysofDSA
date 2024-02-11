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
        int m = 1;
        int e = nums.length - 1;
        for(int i = 0; i <nums.length - 2 ; i ++){
            m = i+1;
            e = nums.length -1;
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
                    while (nums[e] == nums[e - 1] && e>m) {
                        e--;
                    }
                    e--;
                    continue;
                } else if(cSum > 0){
                    e--;
                } else {
                    m++;
                }
                                
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0};

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }
}
