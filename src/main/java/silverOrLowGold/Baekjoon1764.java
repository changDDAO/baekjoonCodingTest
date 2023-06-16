package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> noListen = new ArrayList<>();
        List<String> noSee = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            noListen.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            noSee.add(br.readLine());
        }
        int cnt =0;
        for (int i = 0; i < n; i++) {
            if (noSee.contains(noListen.get(i))) {
                cnt++;
                sb.append(noListen.get(i)+"\n");
            }
            }
        System.out.println(cnt);
        System.out.println(sb.toString());
        }



}
