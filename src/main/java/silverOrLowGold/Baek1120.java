package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sArray = s.split(" ");
        String a = sArray[0];
        String b = sArray[1];
        int diff = a.length();
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int sum =0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j)!=b.charAt(j+i))sum++;
            }
            if(diff>sum)diff=sum;
        }
        System.out.println(diff);
}
}
