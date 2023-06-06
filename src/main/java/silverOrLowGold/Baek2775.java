package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dpTable = new int[15][15];
        for (int i = 1; i < dpTable[0].length; i++) {
            dpTable[0][i]=i;
        }
        for (int i = 1; i < dpTable.length; i++) {
            for (int j = 1; j < dpTable[0].length; j++) {
                int sum = 0;
                for (int k = 1; k <= j; k++) {
                    sum+=dpTable[i-1][k];
                }
                dpTable[i][j]=sum;
            }
        }


        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dpTable[k][n]+"\n");
        }
        System.out.println(sb.toString());
    }
}
