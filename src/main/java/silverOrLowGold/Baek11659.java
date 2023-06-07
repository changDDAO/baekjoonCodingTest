package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s=br.readLine().split(" ");
        int[] numArray = new int[n+1];
        for (int i = 1; i <= n; i++) {
            numArray[i]=Integer.parseInt(s[i-1])+numArray[i-1];
        }//누적합으로 초기화
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int answer =numArray[b]-numArray[a-1];
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}
