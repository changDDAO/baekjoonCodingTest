package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1));
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
