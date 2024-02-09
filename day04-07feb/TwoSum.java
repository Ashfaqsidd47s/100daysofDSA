import java.util.Arrays;

class TwoSum{
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

    public static int binarySearch(int[] nums, int target){
        int start = 0; 
        int end = nums.length - 1;

        while (start <= target) {
            int mid =  start + (end - start)/2;

            if(target == nums[mid]){
                return mid;
            } else if(target > nums[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] nums, int target, int l){
        for(int i = 0; i < nums.length; i++){

            if(i != l && nums[i] == target){
                return i;
            }
        }

        return -1;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] realNums = new int[nums.length];
        System.arraycopy(nums, 0, realNums, 0, nums.length);
        selectionSort(nums);

        int[] result = {-1,-1};

        int left = 0;
        int right = nums.length -1 ;

        while (left < right) {
            int chekSum = nums[left] + nums[right];

            if(chekSum == target){
                result = new int[]{nums[left], nums[right]};
                System.out.println(Arrays.toString(result));
                break;
            } else if(chekSum > target){
                right--;
            } else {
                left++;
            }
        }
         
        if(result[0] != -1){
            result[0] = linearSearch(realNums, result[0],-1);
            result[1] = linearSearch(realNums, result[1], result[0]);
            selectionSort(result);
        }
        System.out.println(Arrays.toString(realNums));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,-3,4,-1};

        int[] reult = twoSum(nums, -1);


        System.out.println(Arrays.toString(reult));
    }
}