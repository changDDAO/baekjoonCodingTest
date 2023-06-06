package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek10807{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String s = br.readLine();
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int find = Integer.parseInt(br.readLine());
        long count = Arrays.stream(numArr).filter(v -> v == find).count();
        System.out.println(count);
    }
}
