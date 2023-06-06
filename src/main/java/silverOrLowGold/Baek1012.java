package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012 {
    static int[][] srcMap;
    static int[][] nextDir ={{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int veg = Integer.parseInt(st.nextToken());
            srcMap = new int[N][M];
            for (int k = 0; k < veg; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                srcMap[a][b]=1; //맵 초기화 해주기
            }
            for (int c = 0; c < N; c++) {
                for (int d = 0; d < M; d++) {
                    if(srcMap[c][d]==1)
                        bfs(c,d);
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());

    }
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        srcMap[i][j]=0;
        cnt++;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int[] next : nextDir) {
                int nx = x+next[0];
                int ny = y+next[1];
                if(nx<0||nx>=N||ny<0||ny>=M)continue; //배열밖이라면 무시하고 for문 계속
                if(srcMap[nx][ny]==0)continue;
                srcMap[nx][ny]=0;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
