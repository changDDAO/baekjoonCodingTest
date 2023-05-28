package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek16236 {
    static int[][] nextDir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//위 왼순으로 ㄱㄱ
    static int[][] srcMap;
    //정리를 해보자
    //아기상어는 9 즉 시작위치
    //처음 상어크기는 2
    //BFS로 탐색하면서 시간을 측정(단, 물고기를 잡아먹을 수 있는 배열값일때만)
    //시간을 측정하는 맵이 필요
    //거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
    //거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
    /*먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
    먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다*/

   //우선순위 먹을수 있는 물고기가 1인게 1순위 그다음 거리순 2순위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        srcMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] temp = s.split(" ");
            for (int j = 0; j < N; j++) {
                    srcMap[i][j]=Integer.parseInt(temp[j]);
            }
        }
        //원본 맵초기화
        int [] curPos = null;
        //x:세로 y:가로 distance:거리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (srcMap[i][j] == 9) {
                    curPos = new int[]{i,j};
                    srcMap[i][j]=0;
                }
            }
        }

        int fishSize = 2;//초기값
        int eatQuantity = 0;//먹은 물고기양
        int moveDis = 0; //움직인 거리

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : o1[0] != o2[0] ? Integer.compare(o1[0], o2[0])
                            : Integer.compare(o1[1], o2[1]));
            boolean visited[][] = new boolean[N][N];
            pq.offer(new int[]{curPos[0], curPos[1], 0});
            visited[curPos[0]][curPos[1]]=true;
            boolean checkEat = false;
            while (!pq.isEmpty()) {
                curPos = pq.poll();
                if (srcMap[curPos[0]][curPos[1]] != 0 && srcMap[curPos[0]][curPos[1]] < fishSize) {
                    srcMap[curPos[0]][curPos[1]]=0;
                    eatQuantity++;
                    moveDis+=curPos[2];
                    checkEat=true;
                    break;
                }
                for (int[] next : nextDir) {
                    int nx =curPos[0]+next[0];
                    int ny = curPos[1]+next[1];
                    if(nx<0||nx>=N||ny<0||ny>=N) continue;
                    if(visited[nx][ny])continue;
                    if(srcMap[nx][ny]>fishSize) continue;
                    pq.offer(new int[]{nx, ny, curPos[2] + 1});
                    visited[nx][ny]=true;
                }
            }
            if (!checkEat) {
                break; //전체반복종료
            }
            if (eatQuantity == fishSize) {
                fishSize++;
                eatQuantity=0;
            }
        }
        System.out.println(moveDis);


//https://girawhale.tistory.com/39
    }
}
