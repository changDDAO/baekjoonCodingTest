package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1026 {
    public static void main(String[] args) throws IOException {
        //A배열에서 가장작은수를 B와 곱하고 합한다.
        //단 B배열은 재배치불가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        int[] arrA = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        s = br.readLine();
        int[] arrB = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int idx =0;
        int sum=0;
        for (int i = N - 1; i >= 0; i--) {
            sum+=arrB[i]*arrA[idx++];
        }
        System.out.println(sum);

    }
}
