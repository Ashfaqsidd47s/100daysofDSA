import java.util.ArrayList;
import java.util.List;

public class PermutationTwo {
    public static void helper(int[] nums, int ind, List<List<Integer>> list, ArrayList<Integer> temp){
        if(ind >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        int element = nums[ind];
        for(int i = 0; i <= ind; i++){
            if(temp.size() >0 && temp.getLast() == element){
                return;
            } else {
                temp.add(ind - i, element);
                helper(nums, ind + 1, list, temp);
                temp.remove(temp.size() - 1 - i);
            }

        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(nums, 0, list, temp);
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(permuteUnique(nums));
    }
}
