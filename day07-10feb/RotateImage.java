import java.util.Arrays;

class RotateImage{
    
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < n ; i++){
            for (int j = 0; j < m/2; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for(int i = 0; i < m ; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
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
            //   {10, 11, 12},
            //  {13, 14, 15}
        };

        System.out.println(Arrays.deepToString(matrix));
        
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}