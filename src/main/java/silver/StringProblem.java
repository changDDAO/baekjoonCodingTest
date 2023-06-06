package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            nums[i]= s.charAt(i)-'0';
        }
        int answer = Arrays.stream(nums).sum();
        System.out.println(answer);
    }
}
