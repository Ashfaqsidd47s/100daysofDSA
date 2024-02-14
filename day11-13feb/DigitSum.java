public class DigitSum {
    public static int addDigits(int num) {
        if(num%10 == num){
            return num;
        } else {
            num = helper(num);
        }

    }

    public static int helper(int num){
        if(num%10 == num){
            return num;
        } else {
            return num%10 + helper(num/10);
        }
    }
}
