package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//dfs와 bfs를 같이 사용하여 solve하기 좋은문제
public class Baek14502 {
    public static int[][] refMap;
    public static int [][] srcMap;
    public static int height, width;
    public static int[][] nextDir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int safeZone;
    public static void main(String[] args) throws IOException {
        //0빈칸 1 벽 2 바이러스
        //벽세우고 ->바이러스 퍼뜨리고 -> 안전영역 계산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        srcMap = new int[height][width];
        for (int i = 0; i < height; i++) {
            String s = br.readLine();
            String[] temp = s.split(" ");
            for (int j = 0; j < width; j++) {
                srcMap[i][j]=Integer.parseInt(temp[j]);
            }
        }
         dfs( 0);
        System.out.println(safeZone);
    }
    public static void dfs( int wall) {
        if (wall == 3) {
            int[][] virusMap = spreadVirusMap();
            safeZone= Math.max(safeZone, getSafeZone(virusMap));
            return;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (srcMap[i][j] == 0) {
                    srcMap[i][j] = 1;
                    dfs( wall + 1);
                    srcMap[i][j]=0;
                }
            }
        }
    }
    //bfs
    public static int[][] spreadVirusMap() {
        Queue<int[]> q = new LinkedList<>();
        refMap = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                refMap[i][j] = srcMap[i][j];
                if(refMap[i][j]==2) q.add(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];
            for (int[] next : nextDir) {
                int nx = x + next[0];
                int ny = y + next[1];
                if(nx<0||nx>=height||ny<0||ny>=width)continue;
                if (refMap[nx][ny] == 0) {
                    refMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }

            }
        }
        return refMap;
    }
    public static int getSafeZone(int[][]map) {
        int cnt =0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j]==0)cnt++;
            }
        }
        return cnt;
    }
}
