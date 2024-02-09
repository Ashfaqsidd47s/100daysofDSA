import java.util.Arrays;

class FirstMinimum{
    public static int solution(int[] nums){
        int result = 1;
        int i = 0;

        while (i < nums.length) {
            if(nums[i] > nums.length || nums[i] < 1){
                i++;
            } else {
                if(nums[nums[i] - 1] == nums[i]){
                    i++;
                } else {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

        for(i = 0; i<nums.length; i++){
            if(nums[i] == i+1){
                result++;
            } else {
                result = i+1;
                break;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,7};
        int result = solution(nums);

        System.out.println(result);
    }
}