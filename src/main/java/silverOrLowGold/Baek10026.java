package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek10026 {
    static int[][] nextDir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int [][] map;
    static boolean visited[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    map[i][j]=1;
                }
                else if(s.charAt(j)=='G')
                    map[i][j]=2;
                else map[i][j]=3;
            }
        }
        int cnt =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    canRG(1, i, j);
                    cnt++;
                } else if (map[i][j] == 2) {
                    canRG(2,i,j);
                } else canRG(3, i, j);
            }
        }
        System.out.println(cnt);


    }
    static void canRG(int target, int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y]=true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dx = cur[0];
            int dy = cur[1];

            for (int[] next : nextDir) {
                int nx = dx+next[0];
                int ny = dy+next[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(visited[nx][ny])continue;
                if(!visited[nx][ny]&&map[nx][ny]==target)
                q.offer(new int[]{nx, ny});
                visited[nx][ny]=true;
            }

        }

    }


}
