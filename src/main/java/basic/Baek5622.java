package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dialStr = {"","","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        int sum =0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < dialStr.length; j++) {
                if (dialStr[j].contains(String.valueOf(s.charAt(i)))) {
                    sum+=j;
                    break;
                }
            }
        }
        System.out.println(sum);

    }
}
