package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int M = Integer.parseInt(br.readLine());
        s = br.readLine();
        int[] findNums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < M; i++) {
            System.out.println(biSerach(numArr,0,numArr.length,findNums[i]));
        }


    }

    private static int biSerach(int[] arr, int start, int end, int target) {

        int left = start;
        int right = end - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left=mid+1;
            }else if (arr[mid]==target) return 1;
            else right = mid - 1;

        }
        return 0;
    }
}

