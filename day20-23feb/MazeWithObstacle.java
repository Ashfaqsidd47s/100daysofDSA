import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeWithObstacle {

    public static int restrictionPathCount(boolean[][] maze,int r,int c){
        if(r == maze.length - 1 || c== maze.length - 1){
            return 1;
        }

        int right =0, down =0;
        if(maze[r + 1][c]){
            down = restrictionPathCount(maze,r +1,c);
        }
        if(maze[r][c+1]){
            right = restrictionPathCount(maze,r,c+1);
        }
        return right + down;
    }

    public  static void restrictionPaths(boolean[][] maze, int r, int c, List<String> list, String temp){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            list.add(temp);
            return;
        }

        if(r < maze.length - 1 && maze[r + 1][c]){
            restrictionPaths(maze, r+1,c,list, temp + "D");
        }
        if(c < maze[0].length - 1 && maze[r ][c + 1]){
            restrictionPaths(maze, r,c + 1,list, temp + "R");
        }
    }

    public  static void allPaths(boolean[][] maze, int r, int c, List<String> list, String temp){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            list.add(temp);
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;

        //down
        if(r < maze.length - 1 ){
            allPaths(maze, r + 1,c,list, temp + "D");
        }
        //right
        if(c < maze[0].length - 1){
            allPaths(maze, r,c + 1,list, temp + "R");
        }
        //up
        if(r > 0 ){
            allPaths(maze, r - 1,c,list, temp + "U");
        }
        //left
        if(c > 0){
            allPaths(maze, r,c - 1,list, temp + "L");
        }

        //removing the changes that we have made in the orignal matrix
        maze[r][c] = true;
    }

    //As we travel count the step and print it with the array
    public static void allPathCount(boolean[][] maze, int[][] pathTrack, int r,int c, int step, List<String> list, String temp){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            list.add(temp);
            printMatrix(pathTrack);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        pathTrack[r][c] = step;

        //down
        if(r < maze.length - 1 ){
            allPathCount(maze, pathTrack,r + 1,c,step + 1,list, temp + "D");
        }
        //right
        if(c < maze[0].length - 1){
            allPathCount(maze, pathTrack,r ,c + 1,step + 1,list, temp + "R");
        }
        //up
        if(r > 0 ){
            allPathCount(maze, pathTrack,r - 1,c,step + 1,list, temp + "U");
        }
        //left
        if(c > 0){
            allPathCount(maze, pathTrack,r ,c - 1,step + 1,list, temp + "L");
        }

        //removing the changes that we have made in the orignal matrix
        maze[r][c] = true;
        pathTrack[r][c] = 0;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();  // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        System.out.println("Maze with Restrictions...");
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        System.out.println("Total No of paths posible :" + restrictionPathCount(maze,0,0));

        System.out.println("Actual paths followed ...");
        List<String> list = new ArrayList<>();
        restrictionPaths(maze,0,0,list, "");
        System.out.println(list);

        System.out.println("All paths we can move in all directions...");
        List<String> list2 = new ArrayList<>();
//        allPaths(maze,0,0,list2, "");
        int[][] pathTracer = new int[3][3];
        allPathCount(maze, pathTracer,0,0,0,list2, "");
        System.out.println(list2);

    }
}
