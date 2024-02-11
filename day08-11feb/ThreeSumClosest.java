public class ThreeSumClosest {
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

    public static int closest(int mostClosest, int sum, int target){
        if(Math.abs(target - mostClosest) < Math.abs(target - sum)){
            return mostClosest;
        } else {
            return sum;
        }
    }

    public static int threeSumClosest(int[] nums, int target) {
        selectionSort(nums);
        int m = 1;
        int e = nums.length - 1;
        int i = 0;
        int mostClosest = nums[i] + nums[m] + nums[e];;
        for( i = 0; i <nums.length - 2 ; i ++){
            m = i+1;
            e = nums.length -1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            while (m < e) {
                int cSum = nums[i] + nums[m] + nums[e];
                if(cSum == target){  
                    mostClosest = cSum;
                    return mostClosest;
                } else if(cSum > target){
                    mostClosest = closest(mostClosest, cSum, target);
                    e--;
                } else {
                    mostClosest = closest(mostClosest, cSum, target);
                    m++;
                }
                                
            }
        }

        return mostClosest;

    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,0};

        int result = threeSumClosest(nums, 1);

        System.out.println(result);

    }
}
