import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSort {

    public static void merge(int[] nums, int start, int mid, int end){
        List<Integer> result = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        while (i<= mid || j<=end) {
            if(i>mid ){
                result.add(nums[j]);
                j++;
                continue;
            }
            if(j> end){
                result.add(nums[i]);
                i++;
                continue;
            }

            if(nums[i]< nums[j]){
                result.add(nums[i]);
                i++;
            } else {
                result.add(nums[j]);
                j++;
            }
        }

        i=start;
        for(int k = 0; k<result.size();k++){
            nums[i]= result.get(k);
            i++;
        }
    }

    public static void sort(int[] nums, int start, int end){
        if(start == end){
            return;
        } 
        int mid = start + (end - start)/2;

        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid , end);
    }
    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1};
        sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
    
}