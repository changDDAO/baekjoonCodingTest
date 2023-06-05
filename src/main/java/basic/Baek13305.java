package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] cost = new long[n];
        long[] dist = new long[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }
        //초기화 완료

        //처음에는 주유하기위해서 어쩔수없이 다음지역 거리에맞게 주유를 해야한다
        //다음 지역으로 가서는 현재 리터당 주유금액과 비교후 작으면 그비용으로 주유한다. 그럼자연스레 최저값이 될 것이다.
        long sum=0;//최종 최소비용
        long minCost = cost[0];
        for (int i = 0; i < n - 1; i++) {
            if(minCost>cost[i]) minCost = cost[i];
            sum+=dist[i]*minCost;
        }
        System.out.println(sum);


    }
}
