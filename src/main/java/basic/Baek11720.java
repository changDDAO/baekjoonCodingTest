package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        int sum = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

    }
}
