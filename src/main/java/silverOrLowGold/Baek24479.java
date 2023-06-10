package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek24479 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int [] order;
    static int n ,cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        order = new int[n+1];
        visited = new boolean[n+1];// 정점의 번호와 맞춰주기 위함
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            //인접행렬로 그래프 표현하기
        }
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        cnt=1;
        dfs(start);
        for (int i = 1; i < order.length; i++) {
            sb.append(order[i]+"\n");
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int start) {
        if(visited[start])return;
        visited[start]=true;
        order[start]=cnt;
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                cnt++;
                dfs(graph.get(start).get(i));
            }


        }
    }
}
