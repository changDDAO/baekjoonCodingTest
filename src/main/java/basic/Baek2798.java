package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2798 {
    public static int target;
    public static int result;
    public static int [] refArr;
    public static int [] sumArr = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] temp = s.split(" ");
        int N = Integer.parseInt(temp[0]);
        target = Integer.parseInt(temp[1]);
        s = br.readLine();
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        refArr = numArr;
        dfs(0,0,target);
        System.out.println(result);


    }
    public static void dfs(int index, int depth, int target) {
        if (depth == 3) {
            int sum =0;

            for (int i = 0; i < 3; i++) {
                sum+=sumArr[i];
                if(sum>=target)return;
            }
            if(sum<=target)
            result = Math.max(result, sum);


            return;
        }
        for (int i = index; i < refArr.length; i++) {
            sumArr[depth]= refArr[i];
            dfs(index+1,depth+1,target);
        }
    }
}
