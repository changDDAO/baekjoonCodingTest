package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17406 {
    static int[][] srcMap;
    static int [][] rotation;
    static int n, m, k;
    static boolean [] visited;
    static int [] order;
    public static void main(String[] args) throws IOException {
        //구현문제는 생각보다 많은 내공을 필요로 한다. 가장 중요한부분은 조건을 빠짐없이
        //고려하며 구현을 시작해야한다. 모든조건을 고려하지않고 구현한다면 처음부터 새로 코드를 작성해야 할 수 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

    }
    static void rotate(int lx, int ly, int rx, int ry, int[][]copyMap) {
        if(lx==rx&&ly==ry) return;//모든회전이 완료된 상황이므로 종료
        int[] temp = new int[3]; //temp 배열에는 회전하면서 지워질 값들을 미리저장해둔다.
        temp[0] = copyMap[lx][ry];//오른쪽모서리
        temp[1] = copyMap[rx][ry];//오른쪽아래모서리
        temp[2] = copyMap[rx][ly];//왼쪽아래모서리
        //전체는 시계방향
        //오른쪽으로 회전
        for (int i = ry; i > ly; i--) {
            copyMap[lx][i] = copyMap[lx][i - 1];
        }
        //아래로 회전
        for (int i = rx; i > lx; i--) {
            copyMap[i][ry]=copyMap[i-1][ry];
        }



    }
}
