package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dpTable = new int[n + 1];
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //dp를 이용하여 현재값과 현재값까지 연속된 합을 비교하여 dp에 저장
        //그중 dpTable에 저장된 값중 가장 큰값이 answer
        dpTable[1]= arr[1];
        int max = arr[1];
        for (int i = 2; i <= n; i++) {
            dpTable[i]= Math.max(dpTable[i-1]+arr[i],arr[i]);
            max = Math.max(dpTable[i],max);
        }
        System.out.println(max);

    }
}
