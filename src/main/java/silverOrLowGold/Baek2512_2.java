package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2512_2 {
    static int n, m;
    static int[] requestBudget;
    static int optimizeBudget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        requestBudget = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            requestBudget[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(requestBudget);
        biSearch();
        System.out.println(optimizeBudget);
    }
    static void biSearch() {
        int start = 0;
        int end = requestBudget[n-1];
        while (start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            for (int i=0; i<n;i++) {
                if(requestBudget[i]>mid)
                    sum+=mid;
                else sum += requestBudget[i];
            }
            if (sum > m) {
                end = mid - 1;
            } else {
                start=mid+1;
                optimizeBudget = mid;
            }

        }

    }
}
