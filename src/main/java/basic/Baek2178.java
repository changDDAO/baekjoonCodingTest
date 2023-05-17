package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2178 {
    private static int [][] countMap;
    private static boolean[][] visited;
    private static int[][] srcMap;
    private static int [][] nextDir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//상하좌우 정의                                                                                             {}
    public static void main(String[] args) throws IOException {
        //1일때 갈수있고, 0은 벽이다. BFS로 해결가능
        Queue<int[]> q = new LinkedList<>();//BFS를 큐를 이용하여 구현

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        countMap = new int[n][m];
        visited = new boolean[n][m];
        srcMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s= br.readLine();
            for (int j = 0; j < m; j++) {
                srcMap[i][j]=s.charAt(j)-'0';
            }
        }
        //맵 초기화 완료
        q.offer(new int[]{0, 0});
        visited[0][0]=true;
        countMap[0][0]=1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            for (int[] nextGo : nextDir) {
                int nx = x + nextGo[0];
                int ny = y + nextGo[1];
                if(nx<0||nx>=n||ny<0||ny>=m)continue;
                if(visited[nx][ny]||srcMap[nx][ny]==0)continue;
                q.offer(new int[]{nx, ny});
                countMap[nx][ny]= countMap[x][y]+1;
                visited[nx][ny]= true;
            }
        }
        System.out.println(countMap[n-1][m-1]);




    }
}
