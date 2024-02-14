class AlternatingDigitSum{

    public static int alternateDigitSum(int n) {
        if(n%10 == n){
            return n;
        } else {

            int digits = (int)(Math.log10(n));
            int rem = n%10;
            if(digits%2 == 1){
                return alternateDigitSum(n/10) - rem;
            } else {
                return alternateDigitSum(n/10) + rem;
            }
        }
    }


    public static void main(String[] args) {
        int n = 1111;
        int result = alternateDigitSum(n);
        System.out.println(result);
    }
}