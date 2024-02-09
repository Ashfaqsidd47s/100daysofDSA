class SubarraySum{

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        

        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        if(presum[0] ==  k){
            result++;
        }
        for(int i = 1; i < nums.length; i++){
            presum[i] = nums[i] + presum[i - 1];
            if(presum[i] == k){
                result++;
            }
        }

        for(int i = presum.length - 1; i > 0; i--){
            for(int j = 0; j < i ; j++ ){
                int saSum = presum[i] - presum[j];
                if(saSum == k){
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println(result);
    }
}