package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] dpTable = new int[11];
        dpTable[1]=1;
        dpTable[2]=2;
        dpTable[3]=4;
        for (int i = 4; i < dpTable.length; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2] + dpTable[i - 3];
        }
        for (int i = 0; i < tc; i++) {
            int v = Integer.parseInt(br.readLine());
            sb.append(dpTable[v] + "\n");
        }
        System.out.println(sb.toString());

    }
}
