package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2667 {

    public static int n;
    public static boolean [][] visited;
    public static int cnt;
    public static List<Integer> houseCountList = new ArrayList<>();
    public static int[][]srcMap;
    public static int[][] nextDir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        srcMap = new int[n][n];
        visited = new boolean[n][n];
        //map 초기화 해주기
        for (int i = 0; i < n; i++) {
            String s =br.readLine();
            for (int j = 0; j < n; j++) {
                srcMap[i][j] = s.charAt(j) - '0';
            }
        }
        // 배열 순회하면서 1발견시 바로 bfs수행 전파시키기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(srcMap[i][j]==1&&!visited[i][j])
                    bfs(i,j);
            }
        }
        Collections.sort(houseCountList);
        sb.append(houseCountList.size() + "\n");
        houseCountList.forEach(v->sb.append(v+"\n"));
        System.out.println(sb.toString());
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q= new LinkedList<>();
        visited[x][y]= true;
        cnt =1;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    int a =pos[0];
                    int b = pos[1];
                    for (int[] next : nextDir) {
                        int nx = next[0]+a;
                        int ny = next[1]+b;
                        if(nx<0||nx>=n||ny<0||ny>=n)continue;
                        if(visited[nx][ny])continue;
                        if (srcMap[nx][ny] == 1) {
                            cnt++;
                            visited[nx][ny]=true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
        }
        houseCountList.add(cnt);

    }
}
