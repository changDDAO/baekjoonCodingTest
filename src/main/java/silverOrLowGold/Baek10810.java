package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10810 {
    static int n, m;
    static int [] baskets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        baskets = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            pushBall(start, end, num);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(baskets[i]+" ");
        }

    }
    static void pushBall(int start, int end, int num) {
        for (int i = start; i <= end; i++) {
            baskets[i]=num;
        }
    }
}
