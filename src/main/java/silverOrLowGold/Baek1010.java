package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1010 {
    public static int[][] dp = new int[30][30];
    //시간초과가 뜬 관계로 TopBottom 방식이아닌 BottomUp방식으로
   /* public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++) {
            s= br.readLine();
            String[] temp = s.split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            System.out.println(comb(M,N));

        }


    }
    public static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return comb(n - 1, r - 1) + comb(n - 1, r);
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < 30; i++) {
            dp[i][i]=1;
            dp[i][0]=1;
        }
        for (int j = 2; j < 30; j++) {
            for (int k = 1; k < 30; k++) {
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
            }
        }

        for (int i = 0; i < n; i++) {
            s= br.readLine();
            String[] temp = s.split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            System.out.println(dp[M][N]);
        }

    }

}
