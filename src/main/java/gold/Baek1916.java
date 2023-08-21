package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1916 {
    static int n, m;
    static  boolean [] visited;
    static int [] dist;
    static List<List<City>> graph = new ArrayList<>();

    static class City implements Comparable<City>{
        int cityNum;
        int dist;

        public City(int cityNum, int dist) {
            this.cityNum = cityNum;
            this.dist = dist;
        }

        @Override
        public int compareTo(City o) {
            return this.dist- o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<=n;i++)
        graph.add(new ArrayList<>());
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new City(b,cost));
            //각 노드간 비용 초기화 해주기
        }
        String[] temp = br.readLine().split(" ");
        int start =  Integer.parseInt(temp[0]);
        int end =  Integer.parseInt(temp[1]);
        System.out.println(dijkstra(start, end));

    }
    static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        dist[start]=0;
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            if (!visited[cur.cityNum]) {
                visited[cur.cityNum]=true;
                for (City city : graph.get(cur.cityNum)) {
                    if (!visited[city.cityNum]&&dist[city.cityNum] > dist[cur.cityNum] + city.dist) {
                        dist[city.cityNum]=dist[cur.cityNum]+city.dist;
                        pq.offer(new City(city.cityNum, dist[city.cityNum]));
                    }
                }
            }
        }
        return dist[end];
    }
}
