package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11660 {
    static int [][] srcMap;
    static int [][] dpMap;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        srcMap = new int[n+1][n+1];
        //dp Map 에 일관성이 없다 주어진 M크기만큼 좌표에서 누적합을
        dpMap = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                srcMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dpMap[i][j]= dpMap[i][j-1]+srcMap[i][j];
            }
        }//dpMap 초기화

        int[] startEnd = new int[4];
        int index = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                startEnd[index++] = Integer.parseInt(st.nextToken());
            }
            index = 0;
            sb.append(calc(startEnd) + " " + "\n");
        }
        System.out.println(sb.toString());


    }static int calc(int [] pos) {

        int startX= pos[0];
        int startY = pos[1];
        int endX = pos[2];
        int endY = pos[3];
        int sum = 0;
        for (int i = startX; i <= endX; i++) {
            sum += dpMap[i][endY] - dpMap[i][startY - 1];
        }
        return sum;
    }
}
