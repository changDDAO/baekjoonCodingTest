package basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            LinkedList<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                boolean check = true;
                int[] first = q.poll();
                for (int j = 0; j < q.size(); j++) {
                    if (first[1] < q.get(j)[1]) {
                        q.offer(first);
                        for (int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }
                        check =false;
                        break;
                    }
                }
                if(!check)continue;
                cnt++;
                if(first[0]==M) break;

            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);



    }
}