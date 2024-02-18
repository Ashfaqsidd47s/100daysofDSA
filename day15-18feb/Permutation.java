import java.util.ArrayList;
import java.util.List;

class Permutation {

    public static void permutHelper(int[] nums, int ind, List<List<Integer>> left, List<Integer> temp){
        if(ind>= nums.length){
            left.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i<=ind; i++){
            temp.add(ind - i ,nums[ind]);
            permutHelper(nums, ind + 1, left, temp);
            temp.remove((Integer)(nums[ind]));
        }
        
        
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        permutHelper(nums, 0, list, ls);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);

    }
    
}