import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsTwo {
    public static void helper(int[] nums, int ind, List<List<Integer>> list, ArrayList<Integer> temp){
        if(ind >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        int element = nums[ind];
        temp.add(element);
        helper(nums, ind + 1, list, temp);
        temp.remove(temp.size() - 1);
        if(temp.size() >0 && temp.getLast() == element){
            return;
        } else {
            helper(nums, ind + 1, list, temp);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, result, temp);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));

    }


}