package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11724 {
    static boolean visited[]=new boolean[1001];
    static int graph[][]=new int[1001][1001];
    static int N, M;// node의 갯수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b]=graph[b][a]=1;
        }
        int cnt=0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static void dfs(int x) {
        if(visited[x])return;
        visited[x] = true;
        for (int j = 1; j <= N; j++) {
            if (graph[x][j] == 1) {
                dfs(j);
            }

        }
    }
}
