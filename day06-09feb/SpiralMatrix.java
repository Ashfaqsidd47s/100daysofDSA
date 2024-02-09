import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;

        int a = 0;

        int min = n;
        if(m<n){
            min= m;
        }

        for(int x = 0; x < min/2; x++){
            while (i == x && j < n - x) {
                result.add(matrix[i][j]);
                System.out.println(result.get(a));
                j++;
                a++;
            }
            j--;
            if(i == x && j == n - x - 1){
                i++;
            }
            while (j == n - 1 - x && i < m - x) {
                result.add(matrix[i][j]);
                System.out.println(result.get(a));
                i++;
                a++;
            }
            i--;
            if(i == m - x - 1 && j == n - 1 -x){
                j--;
            }
            while (i == m - 1 - x && j >= x) {
                result.add(matrix[i][j]);
                System.out.println(result.get(a));
                j--;
                a++;
            }
            j++;
            if(i == m - x - 1 && j == x){
                i--;
            }
            while (j == x && i > x) {
                result.add(matrix[i][j]);
                System.out.println(result.get(a));
                i--;
                a++;
            }
            a--;
            i++;
            j++;
        }

        if(min%2 == 1){
            if( min == n ){
                for(i = min/2; i < m - min/2; i++ ){
                    result.add(matrix[i][j]);
                }
            } else {
                for(j = min/2; j < n - min/2; j++ ){
                    result.add(matrix[i][j]);
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        int[][] matrix = {
            // {1,2,3,4,5,6},
            // {7,8,9,10,11,12},
            // {13,14,15,16,17,18},
            // {19,20,21,22,23,24},
            // {25,26,27,28,29,30},
            //    {1,2,3,4},
            //    {5,6,7,8},
            //    {9,10,11,12},
            //    {13, 14, 15, 16},
            //   {17, 18, 19, 20},
            //   {21, 22, 23, 24},
            //   {25, 26, 27, 28},
            //  {29, 30, 31, 32},
            //  {33, 34, 35, 36},
            // {37, 38, 39, 40}
            //  {13,14,15,16},
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9},
              {10, 11, 12},
            //  {13, 14, 15}
        };
        
        result = spiralOrder(matrix); 
        System.out.println(result);

    }


    
}