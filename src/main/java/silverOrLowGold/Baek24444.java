package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24444 {
    static int n, m, start;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean [] visited;
    static int [] orders;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited =  new boolean[n+1];
        orders  = new int[n+1];
        //node 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        q.offer(start);
        int order = 1;
        orders[start]=order;
        visited[start]= true;
        while (!q.isEmpty()) {
            int curNode =  q.poll();
            orders[curNode]=order++;
            Collections.sort(graph.get(curNode));
            for (int i = 0; i < graph.get(curNode).size(); i++) {
                if (!visited[graph.get(curNode).get(i)]) {
                    q.offer(graph.get(curNode).get(i));
                    visited[graph.get(curNode).get(i)]=true;
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(orders[i]);
        }
    }
}
