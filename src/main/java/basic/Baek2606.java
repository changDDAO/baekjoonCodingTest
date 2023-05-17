package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2606 {
   /* public static int[] parent = new int[101];
    public static int findParent(int x) {
        if(parent[x]==x) return x;
        return parent[x] = findParent(parent[x]);
    }
    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a]=b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        for (int i = 1; i <= node; i++) {
            parent[i] = i;//부모테이블을 자기 자신으로 초기화
        }
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);

        }
        int cnt  =0;
        for (int i = 1; i <= node; i++) {
            if(findParent(i)==1) cnt++;
        }
        if(cnt==1){ System.out.println(0);
        return;}

        System.out.println(cnt-1);
        
    }*/
    public static int [][] graph;
    public static int count;
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b]=1;
            graph[b][a]=1;
        }
        dfs(graph, 1);
        System.out.println(count-1);


   }
   public static void dfs(int[][] map, int v) {
        if(visited[v]) return;
        visited[v]=true;
        count++;
       for (int i = 0; i < graph[v].length; i++) {
           if(graph[v][i]==1&&!visited[i])
               dfs(map, i);
       }

   }
}
