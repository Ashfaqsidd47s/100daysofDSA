public class WaterContainer {
    public static int getArea(int[] height,int i,int j){
        int area;
        if(height[i]>height[j]){
            area = (Math.abs(j - i))*height[j];
        } else {
            area = (Math.abs(j - i))*height[i];
        }

        return area;
    }
    public  static int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int currentArea = getArea(height, start, end);
            if(currentArea > max){
                max = currentArea;
            }
            if(height[start] < height[end]){
                start++;
            } else {
                end--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        int resut = maxArea(height);

        System.out.println(resut);
    }
}
