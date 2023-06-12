package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int left = 0;
            int right = 0;

            for (int j = 0; j < s.length(); j++) {
                char gwalho = s.charAt(j);
                if(gwalho=='(')left++;
                else if(gwalho==')')right++;

                if (right > left) {
                    System.out.println("NO");
                    break;
                }
            }
            if(left==right) System.out.println("YES");
            else if(left>right)System.out.println("NO");
        }


    }
}
