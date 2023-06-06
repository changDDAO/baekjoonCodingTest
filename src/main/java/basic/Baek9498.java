package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        if(score>=90){ System.out.println("A");
            return;}

        if(score>=80){ System.out.println("B");
        return;}

        if (score >= 70) {
            System.out.println("C");
            return;
        }
        if (score >= 60) {
            System.out.println("D");
            return;
        } else {
            System.out.println("F");
        }

    }
}
