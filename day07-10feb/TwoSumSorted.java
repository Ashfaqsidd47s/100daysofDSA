import java.util.Arrays;

public class TwoSumSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = {0,0}; 
        int i = 0;
        int j = numbers.length - 1;
        while (i<j) {
            int cSum = numbers[i] + numbers[j];
            if(cSum == target){
                result = new int[]{i+1, j+1};
                return result;
            } else if(cSum > target){
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers ={1,3,4,6,7,8,9};

        int[] result = twoSum(numbers, 5);

        System.out.println(Arrays.toString(result));
    }
}
