package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TopologySort 이용하기
public class Baek2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //진입차수 배열 초기화 해주기
        int[] inDegree = new int[N + 1];
        //graph 초기화 해주기
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i]==0)q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur+" ");
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                inDegree[next]--;
                if(inDegree[next]==0)
                    q.offer(next);
            }
        }
        System.out.println(sb.toString());




    }
}
