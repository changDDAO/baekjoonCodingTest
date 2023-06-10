package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek10026 {
    static int[][] nextDir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int n;
    static char [][]map;
    static boolean [][]visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j]=s.charAt(j);
            }
        }//map 입력받기
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }

            }
        }
        sb.append(cnt + " ");
        //적록색맹이라 적색과 녹색을 구별하지 못하는 사람들은 같은색으로 취급하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='G')
                    map[i][j]='R';
            }
        }
        visited = new boolean[n][n];
        cnt =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }

            }
        }
        sb.append(cnt);
        System.out.println(sb.toString());





    }
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y]=true;
        char curColor = map[x][y];
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int dx = current[0];
            int dy = current[1];
            for (int[] next : nextDir) {
                int nx = dx + next[0];
                int ny = dy + next[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny])continue;
                if (map[nx][ny] == curColor) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
        }

    }

}
