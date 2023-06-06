package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] students = new int[31];
        for (int i = 0; i < 28; i++) {
            int check = Integer.parseInt(br.readLine());
            students[check]=1;
        }

        for (int i = 1; i <= 30; i++) {
            if(students[i]!=1) sb.append(i + "\n");
        }
        System.out.println(sb.toString());

    }

}
