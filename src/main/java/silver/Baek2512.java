package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2512 {
    public static void main(String[] args) throws IOException {
        //BinarySearch로 풀자
        //찾는 mid값을 상한액으로 두고 array를 순회하면서 합하여 전체 국가예산 M과 비교한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] reqByCountry = new int[N];
        String [] countries = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());//국가 총 예산
        for (int i = 0; i < N; i++) { //초기화 해주기
            reqByCountry[i] = Integer.parseInt(countries[i]);
        }
        Arrays.sort(reqByCountry);
        //core
        int answer =0;
        int start = 0;
        int end = reqByCountry[N - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int budget : reqByCountry) {
                if(budget>mid)sum+=mid;
                else sum += budget;
            }
            if (sum > M) {
                end = mid - 1;
            } else {
                start = mid+1;
                answer = mid;
            }
        }
        System.out.println(answer);


    }
}
