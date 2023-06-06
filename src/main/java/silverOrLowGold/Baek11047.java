package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] > target) {
                continue;
            } else {
                while (true) {
                    if(target<coins[i])break;
                    target-=coins[i];
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
