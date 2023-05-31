package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dpTable = new int[5001];
        dpTable[3]=1;
        dpTable[5]=1;

        for (int i = 6; i <= N; i += 3) {
            dpTable[i]=dpTable[i-3]+1;
        }
        for (int j = 10; j <= N; j += 5) {

        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(dpTable[i]);
        }

    }
}
