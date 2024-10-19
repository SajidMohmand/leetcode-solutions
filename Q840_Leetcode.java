import java.util.Arrays;
import java.util.HashSet;

public class Q840_Leetcode {
    public static int helper(int row,int col, int[][] grid){
        int prev = 0;
        if (row != -1){
            for (int i=0; i<3;i++){
                int sum = 0;
                for (int j=0; j<3; j++){
                    sum += grid[i][j];
                }
                if (i==0){
                    prev = sum;
                    continue;
                }
                if (prev != sum){
                    return 0;
                }
            }
        }else{
            for (int i=0; i<3;i++){
                int sum = 0;
                for (int j=0; j<3; j++){
                    sum += grid[j][i];
                }
                if (i==0){
                    prev = sum;
                    continue;
                }
                if (prev != sum){
                    return 0;
                }
            }
        }

        return 1;
    }
    public static int numMagicSquaresInside2(int[][] grid) {


        if(grid.length < 1 || grid[0].length > 10){
            return 0;
        }
        if (helper(0,-1,grid) == 0 || helper(-1,0,grid) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    // Method to count total Magic square subgrids
    public static int numMagicSquaresInside(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int ans = 0;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                if (grid[i + 1][j + 1] != 5)
                    continue;
                int a = grid[i][j];
                int b = grid[i][j + 1];
                int c = grid[i][j + 2];
                int d = grid[i + 1][j];
                int e = grid[i + 1][j + 1];
                int f = grid[i + 1][j + 2];
                int g = grid[i + 2][j];
                int h = grid[i + 2][j + 1];
                int i2 = grid[i + 2][j + 2];
                HashSet<Integer> s1 = new HashSet<>(
                        Arrays.asList(a, b, c, d, e, f, g, h, i2));
                HashSet<Integer> s2 = new HashSet<>(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                if (s1.equals(s2) &&
                        (a + b + c) == 15 && (d + e + f) == 15 && (g + h + i2) == 15 &&
                        (a + d + g) == 15 && (b + e + h) == 15 && (c + f + i2) == 15 &&
                        (a + e + i2) == 15 && (c + e + g) == 15) {

                    ans += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] grid = {{4,3,8,4}
                        ,{9,5,1,9}
                        ,{2,7,6,2}
                        };


        System.out.println(numMagicSquaresInside(grid));

    }




}
