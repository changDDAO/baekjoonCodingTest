package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17406 {
    static int[][] srcMap;//원본배열
    static int [][] rotation;// 회전방법을 담을배열
    static int n, m, k;
    static int min = Integer.MAX_VALUE;
    static boolean [] visited;
    static int [] order;
    //test
    public static void main(String[] args) throws IOException {
        //구현문제는 생각보다 많은 내공을 필요로 한다. 가장 중요한부분은 조건을 빠짐없이
        //고려하며 구현을 시작해야한다. 모든조건을 고려하지않고 구현한다면 처음부터 새로 코드를 작성해야 할 수 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        srcMap = new int[n][m];
        rotation = new int[k][3];
        visited = new boolean[k];
        order = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                srcMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }
        findAllCase(0,k);
        System.out.println(min);
    }
    static void rowMin(int[][] copyMap) {
        for (int i = 0; i < copyMap.length; i++) {
            int sum =0;
            for (int j = 0; j < copyMap[0].length; j++) {
                sum+=copyMap[i][j];
            }
            min = Math.min(min, sum);
        }
    }
    static void findMin(int[][]copyMap) {
        for (int i = 0; i < order.length; i++) {
            int lx = rotation[order[i]][0]-rotation[order[i]][2]-1;
            int ly = rotation[order[i]][1]-rotation[order[i]][2]-1;
            int rx = rotation[order[i]][0]+rotation[order[i]][2]-1;
            int ry = rotation[order[i]][1]+rotation[order[i]][2]-1;
            rotate(lx,ly,rx,ry,copyMap);
        }
        rowMin(copyMap);
    }
    static void findAllCase(int cnt, int k) {
        if (cnt == k) {
            int[][] oneCase = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    oneCase[i][j] = srcMap[i][j];
                }
            }
            findMin(oneCase);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i]=true;
                order[cnt]=i;
                findAllCase(cnt+1,k);
                visited[i]=false;
            }

        }
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
            if(i==lx+1) copyMap[i][ry] = temp[0];
            else copyMap[i][ry]=copyMap[i-1][ry];
        }
        //왼쪽으로 회전
        for (int i = ly; i < ry; i++) {
            if(i==ry-1)copyMap[rx][i]=temp[1];
            else copyMap[rx][i] = copyMap[rx][i + 1];
        }
        //위로 회전
        for (int i = lx; i < rx; i++) {
            if(i==rx-1)copyMap[i][ly]=temp[2];
            else copyMap[i][ly]=copyMap[i+1][ly];
        }
        rotate(lx+1,ly+1,rx-1,ry-1,copyMap);

    }
}
