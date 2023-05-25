import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        List<Integer> buyList;
        List<Integer> sellList;
        for (int i = 1; i <= tc; i++) {
            buyList = new ArrayList<>();
            sellList = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int check = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                if(check== 1)sellList.add(value);
                if (check== -1)buyList.add(value);
            }
            Collections.sort(sellList);
            Collections.sort(buyList);
            for (int a = sellList.size() - 1; a >= 0; a--) {
                int cnt = 0;
                for (int b = buyList.size() - 1; b >= 0; b--) {
                    if(sellList.get(a)<buyList.get(b))continue;

                    if (sellList.get(a) == buyList.get(b)) {
                        cnt++;
                        sb.append("#" + i + " " + sellList.get(a));
                        break;
                    }
                    if (sellList.get(a) > buyList.get(b)) {
                        break;
                    }
                }
                if (cnt == 0) {
                    sb.append("#" + i + " " + "0");
                    break;
                }
            }
        }
        System.out.println(sb.toString());

    }
}
