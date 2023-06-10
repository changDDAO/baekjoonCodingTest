package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum =0;
        while (st.hasMoreTokens()) {
            long element = Long.parseLong(st.nextToken());
            sum+=element;
        }
        System.out.println(sum);
    }
}
