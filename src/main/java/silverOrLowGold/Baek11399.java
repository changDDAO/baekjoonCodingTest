package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] opt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int i = 1; i < opt.length; i++) {
            int j = i-1;
                opt[i]+=opt[j];
        }
        int sum = Arrays.stream(opt).sum();
        System.out.println(sum);
    }
}
