package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1018 {
    private static int N, M;
    private static int result = 64;

    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j)=='W')
                    map[i][j]=true;
                else map[i][j]=false;
            }
        }
        //현재 W는 true B는 false;
        //System.out.println(map[0][0]);
        //8x8배열의 모든 경우의수를 다 따져준다.
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M-7; j++) {
                toggleCnt(i,j);
            }
        }
        System.out.println(result);



    }
    private static void toggleCnt(int x, int y) {
        int endX= x+8;
        int endY = y+8;
        int cnt = 0;
        boolean color= map[x][y];
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if(map[i][j]!=color)cnt++;
                color=!color;
            }
            color=!color;
        }
        cnt = Math.min(cnt, 64 - cnt);

        result = Math.min(result, cnt);

    }
}
