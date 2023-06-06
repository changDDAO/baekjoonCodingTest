package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s= br.readLine();
        int[] targetList = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        s= br.readLine();
        s= br.readLine();
        int[] exList = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int t : exList) {
            System.out.print(biSearch(targetList,t)+" ");
        }

    }
    private static int biSearch(int [] targetList, int target) {
        int left = 0;
        int right = targetList.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if(targetList[mid]<target) left=mid+1;
            else if (targetList[mid]==target)return 1;
            else right= mid-1;
        }
        return 0;
    }
}
