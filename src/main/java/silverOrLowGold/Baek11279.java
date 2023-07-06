package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(br.readLine());
            if (node == 0) {
                if(pq.isEmpty())
                    sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            }
            pq.offer(node);
        }
        System.out.println(sb.toString());
    }

}
