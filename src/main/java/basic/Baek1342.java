package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1342 {
    private static int result;
    private static int len;
    public static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        len = s.length();
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)-'a']++;
        }
        dfs(0,' ');
        System.out.println(result);



    }
    public static void dfs(int depth, char pre) {
        if (depth == len) {
            result++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(alphabet[i]==0)continue;
            if (pre != (char) (i + 'a')) {
                alphabet[i]--;
                dfs(depth + 1, (char)(i+'a'));
                alphabet[i]++;
            }
        }
    }




}
