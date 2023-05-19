package basic;
//FloydWarshall Algorithm을 이용해보자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Floyd Warshall Algo
public class Baek1058 {
    static int[][] arr;
    static final int INF = 50;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=n; j++) {
                if(i == j) continue;

                arr[i][j] = s.charAt(j-1) == 'Y'? 1 : INF;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i==j)continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt =0;
            for (int j = 1; j <= n; j++) {
                if(arr[i][j]==1||arr[i][j]==2)cnt++;
            }
            answer = Math.max(answer, cnt);
        }


        System.out.println(answer);
    }
}
