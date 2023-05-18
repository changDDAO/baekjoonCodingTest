package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek2667 {
    public static int[][]refMap;
    public static int[][]srcMap;
    public static int[][] nextDir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> houseCountList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        srcMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s =br.readLine();
            for (int j = 0; j < n; j++) {
                srcMap[i][j] = s.charAt(j) - '0';
            }
        }//map 초기화 해주기



    }
    public static void bfs() {
        Queue<int[]> pos = new LinkedList<>();
        refMap = srcMap;
        int h = refMap.length;
        int w = refMap[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (refMap[i][j] == 1) {

                }
            }
        }
    }
}
