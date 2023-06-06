package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        s = br.readLine();
        int[] numArr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt).filter(v->v<X).toArray();
        for (int v : numArr) {
            System.out.print(v+" ");
        }




    }
}
