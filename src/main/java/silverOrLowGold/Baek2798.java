package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2798 {
 //dfs를 이용하여 문제를 풀었으나 2개의 합산이 500일때가있어 BruteForce 알고리즘으로 다시풀이 진행
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String s = br.readLine();
     String[] temp = s.split(" ");
     int N = Integer.parseInt(temp[0]);
     int target = Integer.parseInt(temp[1]);
     s = br.readLine();
     int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
     int result=0;
     for (int i = 0; i < numArr.length - 2; i++) {
         for (int j = i + 1; j < numArr.length - 1; j++) {
             for (int k = j + 1; k < numArr.length; k++) {
                 int sum = numArr[i] + numArr[j] + numArr[k];
                 if(sum==target){ System.out.println(sum);
                    return;
                 }

                 if(result<sum&&sum<target)
                    result = sum;
             }
         }
     }
     System.out.println(result);

 }

}
