package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Procession {
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arrayA[i][j]);
            }
            System.out.println();
        }
    }
    public static void change(int x, int y) {
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                arrayA[i][j] = 1 - arrayA[i][j];
            }
        }
    }
}
