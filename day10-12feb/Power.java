class Power{
    public static double myPow(double x, int n) {
        if(n<0){
            if(n == -1){
                return 1/x;
            } else {
                return (myPow(x, n +1))*(1/x);
            }
        }else {
            if(n == 1){
                return x;
            } else if(n>0 && n <1){
                
            } else {
                return myPow(x, n-1)*x;
            }
        }
    }

    public static void main(String[] args) {
        double result = myPow(0.00001,2147);
        System.out.println(result);
    }

}