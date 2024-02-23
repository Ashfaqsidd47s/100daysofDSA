import java.util.ArrayList;
import java.util.List;

public class Maze {


    public static int wayCount(int r, int c){
        if(r == 1 || c == 1){
            return  1;
        }

        int down = wayCount(r-1,c);
        int right = wayCount(r,c - 1);
        return down + right;
    }

    public static void paths(int r, int c, List<String> list, String temp ){
        if(r == 1 && c == 1 ){
            list.add(temp);
            return;
        }

        if(r >= 1){
            paths(r-1, c, list, temp + "D");
        }
        if(c >=1){
            paths(r, c-1, list, temp + "R");
        }
    }

    //Including diagonal path also
    public static int diagonalWayCount(int r, int c){
        if(r == 1 || c == 1){
            return  1;
        }

        int down = diagonalWayCount(r-1,c);
        int diagonal = diagonalWayCount(r -1, c -1 );
        int right = diagonalWayCount(r,c - 1);
        return down + right + diagonal;
    }

    public static void diagonalPaths(int r, int c, List<String> list, String temp ){
        if(r == 1 && c == 1 ){
            list.add(temp);
            return;
        }

        if(r >= 1){
            diagonalPaths(r-1, c, list, temp + "D");
        }
        if(r >= 1 && c >= 1){
            diagonalPaths(r -1,c-1, list, temp + "d");
        }
        if(c >=1){
            diagonalPaths(r, c-1, list, temp + "R");
        }
    }

    public static void main(String[] args) {
        System.out.println("Maze problem...");
        int result = wayCount(3,3);
        System.out.println(result);
        List<String> list = new ArrayList<>();
        String temp  = "";
        paths(3,3,list,temp);
        System.out.println(list);

        System.out.println("Diagonal ways Included...");
        System.out.println(diagonalWayCount(3,3));

        System.out.println("Diagonal Paths count");
        List<String> listD = new ArrayList<>();
        String tempD  = "";
        diagonalPaths(3,3,listD,tempD);
        System.out.println(listD);
    }
}
