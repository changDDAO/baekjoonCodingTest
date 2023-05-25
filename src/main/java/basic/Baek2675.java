package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2675 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < tc; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                for (int j = 0; j < s.length(); j++) {
                    for (int k = 0; k < n; k++) {
                        sb.append(s.charAt(j));
                    }
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
}
