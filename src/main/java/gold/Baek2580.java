package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2580 {
    static int[][] srcMap = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //원본 맵 초기화 하기
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                srcMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }
    static boolean canInput(int val, int row, int col) {
        //한 행에서 열을 검사
        for (int i = 0; i < 9; i++) {
            if(srcMap[row][i]==val)return false;
        }
        //한 열에서 행을 검사
        for (int i = 0; i < 9; i++) {
            if(srcMap[i][col]==val) return false;
        }
        int smallRow = (row/3)*3; //0,1,2 index의 경우 0이 시작점  3,4,5 index의 경우 3이 사작점 .....
        int smallCol = (col/3)*3; //0,1,2 index의 경우 0이 시작점  3,4,5 index의 경우 3이 사작점 .....
        for (int i = smallRow; i < smallRow + 3; i++) {
            for (int j = smallCol; j < smallCol + 3; j++) {
                if(srcMap[i][j]==val) return false;
            }
        }
    return true;
    }
    static void sudoku(int row, int col) {
        //한행의 끝열까지 다 탐색을 하면 다음행으로 넘어가 재귀 수행 및 종료
        if (col == 9) {
            sudoku(row+1, 0);
            return;
        }
        //srcMap의 끝행까지 다 탐색을 했다면, 만들어진 Map을 출력 후 종료!
        // 종료를 하는 이유는??
        // 출력 조건에 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
        //스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
        //출력 조건 때문
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(srcMap[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (srcMap[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (canInput(i, row, col)) {
                    srcMap[row][col]=i;
                    sudoku(row, col+1);
                }
            }
            srcMap[row][col]=0;
            return;
        }
        sudoku(row, col+1);


    }





}
