public class ReverseInteger {
    public static int reverse(int x) {
        if(x== 0){
            return 0;
        }
        if(x%10 == x){
            return x;
        } else {
            int digits = (int)(Math.log10(Math.abs(x)));
            int rem = x%10;
            System.out.println(x);
            int rev = reverse(x/10);
            if(rev > 147483647 || rev < -147483648){
                return 0 ;
            }
            int result = rem* (int)(Math.pow(10, digits)) + rev;
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {
        int x =   1137464807;
        int result = reverse(x);
        System.out.println(result);
    }
}
