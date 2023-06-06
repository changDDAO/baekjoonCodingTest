package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1916 {
    public static class City implements Comparable<City>{
        int num;
        int weight;

        public City(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) {
            return weight-o.weight; //오름차순
        }
    }
    public static int INF = Integer.MAX_VALUE;
    public static int n, m;
    public static boolean [] visited;
    public static int []dist;
    public static List<List<City>> cities = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            cities.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);// 최댓값으로 초기화 해주기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cities.get(a).add(new City(b, w));
        }//인접리스트 방식으로 m 간선만큼 입력받아 초기화 해줌

        //다익스트라 알고리즘 수행
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));


    }
    public static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            if (!visited[cur.num]) {
                visited[cur.num] = true;
                for (City city : cities.get(cur.num)) {
                    if (!visited[city.num] && dist[city.num] > dist[cur.num] + city.weight) {
                        dist[city.num]= dist[cur.num]+city.weight;
                        pq.add(new City(city.num, dist[city.num]));
                    }
                }
            }
        }
        return dist[end];
    }
}
