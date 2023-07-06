package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        int[] floor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int score = Integer.parseInt(br.readLine());
            floor[i] = score;
        }
        dp[1] = floor[1];
        if(n>=2)
            dp[2]=floor[1]+floor[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3]+floor[i-1])+floor[i];
        }
        System.out.println(dp[n]);

    }
}
