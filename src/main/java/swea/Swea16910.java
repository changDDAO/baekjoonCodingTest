package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea16910 {
    //문제 x^2+y^2 = n^2 정수인 격자점 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s;
        for (int i = 0; i < N; i++) {
            s= br.readLine();
            int n = Integer.parseInt(s);
            int answer = 0;
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    if(j*j+k*k<=n*n)answer++;
                }
            }
            answer = answer*4+n*4+1;
            System.out.println("#"+(i+1)+" "+answer);
        }

    }
}
