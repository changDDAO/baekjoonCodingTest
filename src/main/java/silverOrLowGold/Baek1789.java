package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1789 {
    static long s;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //S= 서로다른 N개의 합
        //이중에서 출력해야 하는 값은 N의 최댓값
         s = Long.parseLong(br.readLine());
         System.out.println(searchN());


    }
    static int searchN(){
        int num =1;
        long sum = 0L;
        while (true) {
            sum+=num;
            if ( sum> s) {
                answer = num-1;
                return answer;
            }
            num++;
        }
        }

}
