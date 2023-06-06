package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<CurPos> curPosList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            curPosList.add(new CurPos(x,y));
        }
        Collections.sort(curPosList);
        curPosList.stream().forEach(o-> sb.append(o.x+" "+o.y+"\n"));
        System.out.println(sb.toString());

    }
    static class CurPos implements Comparable<CurPos>{
        int x;
        int y;

        public CurPos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(CurPos o) {
            if(x==o.x)return y-o.y;
           return x-o.x;
        }
    }
}
