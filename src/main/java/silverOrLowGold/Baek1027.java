package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1027 {
    //greedy 문제로 아주 훌륭하게 생각한다. 많은 고민을 했지만
    //생각보다 구현이 오래 걸렸던것 같다.
    static int[] buildings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //빌딩 높이 초기화하기
        int N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        int[] visibleBuildingCnt = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            visibleBuildingCnt[i]++;
            visibleBuildingCnt[i+1]++;
            double curInc = buildings[i+1]-buildings[i];
            for (int j = i + 2; j < N; j++) {
                double nextInc = calInclination(i,j);
                if (nextInc > curInc) {
                    visibleBuildingCnt[i]++;
                    visibleBuildingCnt[j]++;
                    curInc= nextInc;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, visibleBuildingCnt[i]);
        }
        System.out.println(max);
    }
    static double calInclination(int x, int y) {
        return (double) (buildings[y]-buildings[x])/(y-x);
    }

}
