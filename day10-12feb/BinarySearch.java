import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start )/2;
        System.out.println(Arrays.toString(nums));

        if(start > end ){
            return -1;
        } else {
            if(target == nums[mid]){
                return mid;
            } else if(target > nums[mid]){
                return search(Arrays.copyOfRange(nums, mid + 1, end + 1), target);
            } else {
                return search(Arrays.copyOfRange(nums, start, mid ), target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,7,8,9};
        int target = 9;
        int result = search(nums, target);
        System.out.println(result);
    }
}
