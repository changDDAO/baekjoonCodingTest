package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1260 {
    //dfs와 bfs
    private static int[][] graph = new int[1001][1001];
    private static boolean[] visited=new boolean[1001];
    public static int n, m, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            s=br.readLine();
            String[] temp = s.split(" ");
            graph[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])]
                    =graph[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])]=1;
        }
        dfs(start);
        System.out.println();
        visited = new boolean[1001];
        bfs(start);
    }


    public static void dfs(int start) {
        visited[start]=true;
        System.out.print(start+" ");

        for (int i = 1; i <= n; i++) {
            if(graph[start][i]==1&&visited[i]==false)
                dfs(i);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start]=true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex+" ");
            for (int i = 1; i <= n; i++) {
                if (graph[vertex][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i]=true;
                }

            }

        }
    }
}
