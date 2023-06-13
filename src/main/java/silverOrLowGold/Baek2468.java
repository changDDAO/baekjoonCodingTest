package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2468 {
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int nextDir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> highSet = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!highSet.contains(map[i][j])) {
                    highSet.add(map[i][j]);
                }
            }
        }//  안전영역이 높이에 따라 매번 바뀌기 때문에 높이가 될수 있는 List를 Set에 담아둔다
        int max = 0;
        for (int high : highSet) {
            visited = new boolean[N][N];
            int cnt  = 0 ;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] >= high) {
                        BFS(i,j,high);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    static void BFS(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y]=true;
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            for (int[] next : nextDir) {
                int nx = curPos[0]+next[0];
                int ny = curPos[1]+next[1];
                if (canGo(nx, ny)&&map[nx][ny]>=num) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }

            }
        }

    }
    static boolean canGo(int x , int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]);
    }
}
