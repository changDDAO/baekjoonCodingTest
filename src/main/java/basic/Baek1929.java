package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1929 {
    //소수구하기
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = a; i <= b; i++) {
            if(isPrime(i)) sb.append(i + "\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean isPrime(int n) {
        if(n==1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n%i==0)return false;
        }
        return true;
    }
}
