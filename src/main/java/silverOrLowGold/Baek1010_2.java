package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010_2 {
    static int T, n, m;
    static int [][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        initDp();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n]+"\n");
        }
        System.out.println(sb.toString());
    }

    static void initDp() {
        //nCr 중 r == 0 이거나 n ==r 이면 경우의 수는 1
        for (int i = 0; i < 30; i++) {
            dp[i][0]=1;
            dp[i][i]=1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
            }
        }
    }
}
