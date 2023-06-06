package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15650 {
    static int [] nums;
    static int [] answer;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        dfs(1,0);

    }
    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= nums.length; i++) {
            answer[depth] = i;
            dfs(i+1,depth+1);
        }
    }
}
