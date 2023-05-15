package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s= br.readLine();
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt=0;
        for (int value : numArr) {
            if(isPrime(value))cnt++;
        }
        System.out.println(cnt);


    }
    public static boolean isPrime(int n) {
        if(n==1)return false;
        int cnt =0;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n%i==0)cnt++;
        }
        if(cnt>=1)return false;
        return true;
    }
}
