public class AddBinary {
    public static String add(String a, String b){
        String result = new String();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >=0) {
            int val1 = 0;
            int val2 = 0;
            if(i>=0){
                val1 = (int)(a.charAt(i)) - (int)('0');
            }
            if(j >= 0){
                val2 = (int)(b.charAt(j)) - (int)('0');
            }
            int sum = (val1 + val2 + carry)%2;
            carry = (val1 + val2 + carry)/2;
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
        String a = "11";
        String b = "1";
        System.out.println(add(a,b));
    }
}
