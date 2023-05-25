package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15649 {
    static int[] answerList;
    static int N, M;
    static boolean []visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];//1부터 시작하기위함
        answerList = new int[M];
        dfs(0);
        System.out.println(sb.toString());

    }
    static void dfs( int depth) {
        if (depth == M) {
            for (int i = 0; i < M ; i++) {
                sb.append(answerList[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i]=true;
                answerList[depth]=i;
                dfs( depth + 1);
                visited[i]=false;
            }
        }

    }
}
