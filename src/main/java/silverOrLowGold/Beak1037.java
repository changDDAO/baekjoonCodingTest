package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s= br.readLine();
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt)
                .sorted().toArray();
        System.out.println(numArr[0]*numArr[numArr.length-1]);

    }
}
