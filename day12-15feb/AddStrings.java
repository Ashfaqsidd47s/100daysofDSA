class AddStrings{
    public static String addStrings(String num1, String num2) {
        String result = new String();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        while (i >= 0 || j >=0) {
            int val1 = 0;
            int val2 = 0;
            if(i>=0){
                val1 = (int)(num1.charAt(i)) - (int)('0');
            } 
            if(j >= 0){
                val2 = (int)(num2.charAt(j)) - (int)('0');
            }
            int sum = (val1 + val2 + carry)%10;
            carry = (val1 + val2 + carry)/10;
            result = String.valueOf(sum) + result;
            i--;
            j--;
        }
        if(carry != 0){
            result = String.valueOf(carry) + result;
        }

        return result;
    }

    public static void main(String[] args) {
        String num1 = "2345";
        String num2 = "5";

        String result = addStrings(num1, num2);

        System.out.println(result);
    }
}