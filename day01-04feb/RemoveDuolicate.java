import java.util.Arrays;

class RemoveDuolicate {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int count = 0;
        int k = nums.length;
        while( i< k - 1) {
            if(i+1<k && nums[i] == nums[i+1]){
                for(int j = i + 1; j< nums.length -1- count; j++){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp; 
                }
                count++;
                k --;
            }
            else{
                i++;
            }
        }
        return k;
    }

    public static int removeDuplicateOptimised(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if(nums[i] < nums[j]){
                if(i + 1 == j){
                    i++;
                    j++;
                } else{
                    int temp = nums[i+1];
                    nums[i+1] = nums[j];
                    nums[j] = temp;
                    j = i + 1;
                }
            } else {
                j++;
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        int nums[] = {0,0,0,1,1,1,1,2,2,3,3,4};
        int k = removeDuplicateOptimised(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}