import java.util.Arrays;

class PairSongs{

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

    public static int numPairsDivisibleBy60(int[] time) {
        int resutl = 0;

        for(int i = 0; i< time.length; i++){
            if (time[i] % 60 == 0) {
                time[i] = 60;
            } else {
                time[i] = time[i] % 60;
            }
        }

        Arrays.sort(time);

        for(int start = 0; start<time.length -1; start++){

            int end = time.length - 1;
    
            while (start < end) {
                int timeSum = time[start] + time[end];
    
                if(timeSum % 60 == 0 ){
                    resutl++;
                    end--;
                } else if( timeSum > 60){
                    end--;
                } else {
                    break;
                }
            }
        }


        return resutl;
    }

    public static int combinatino(int n){
        int resut = 1;
        resut = resut*n/2;
        resut = resut*(n-1);
        return resut;
    }
    public static int numPairs60Aproach2(int[] time){
        int resutl = 0;

        System.out.println(Arrays.toString(time));

        for(int i = 0; i< time.length; i++){
            if (time[i] % 60 == 0) {
                time[i] = 60;
            } else {
                time[i] = time[i] % 60;
            }
        }

        System.out.println(Arrays.toString(time));
        
        Arrays.sort(time);
        
        System.out.println(Arrays.toString(time));
        
        
        int[] count = new int[61];
        for(int i = 0; i < time.length; i++){
            count[time[i]]++;
        }
        
        System.out.println(Arrays.toString(count));


        if(count[60] >= 2){
            resutl = resutl + combinatino(count[60]);
        } 
        for(int i = 1; i <30 ; i++){
            resutl = resutl + (count[i] * count[60 - i]);
        }
        if(count[30] >= 2){
            resutl = resutl + combinatino(count[30]);
        } 

        return resutl;
    }
    public static void main(String[] args) {
        int[] time = {418,204,77,278,239,457,284,263,372,279,476,416,360,18};

        int resutl = numPairs60Aproach2(time);

        System.out.println(resutl);
    }
}