package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
                    if(dist[city.cityNum]>dist[cur.cityNum]+city.dist)
                }
            }
        }
    }
}
