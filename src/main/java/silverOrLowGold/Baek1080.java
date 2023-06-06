package silverOrLowGold;

import java.io.IOException;
import java.util.Scanner;

public class Baek1080 {
    public static int [][] arrayA;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arrayA = new int[n][m];
        int[][] arrayB = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arrayA[i][j] = s.charAt(j) - '0';    
            }
        }

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arrayB[i][j] = s.charAt(j) - '0';
            }
        }
        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (arrayA[i][j] != arrayB[i][j]) {
                    change(i,j);
                    cnt++;
                }

            }
        }
        if(isSame(arrayA,arrayB)) System.out.println(cnt);
        else System.out.println(-1);


    }
    public static void change(int x, int y) {
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                arrayA[i][j] = 1 - arrayA[i][j];
            }
        }
    }
    public  static boolean isSame(int[][] arrayA, int[][]arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA[0].length; j++) {
                if(arrayA[i][j]!=arrayB[i][j])
                    return false;
            }
        }
        return true;
    }
}
