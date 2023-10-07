package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|*/
public class Baek10819 {
    static int n;
    static int [] nums;
    static int [] selectedNums;
    static boolean [] visited;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];// n크기 만큼 숫자를 담을 배열 생성
        visited = new boolean[n]; //n크기 만큼 방문했는지를 판단할 boolean 배열 생성
        selectedNums = new int[n];//permutation에 의해 뽑힌 숫자를 담을 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);

    }
    static void dfs(int cnt) {
        //종료조건
        if (cnt == n) {
            result = Math.max(result, getValue());
            return;
        }
        //recursion
        //backtracking //재귀를 구현할 때, 주의사항 1. 종료저건 2 수행동작
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                selectedNums[cnt] = nums[i];
                visited[i]=true;
                dfs(cnt+1);
                visited[i]=false;
            }
        }

    }


    //permutation 즉 뽑힌 수를 바탕으로 |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| 방법에 맞게
    //계산된 값을 return 해주는 함수
    static int getValue(){
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum+= Math.abs(selectedNums[i]-selectedNums[i+1]);
        }
        return sum;
    }
}
