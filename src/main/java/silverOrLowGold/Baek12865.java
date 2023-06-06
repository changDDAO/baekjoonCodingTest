package silverOrLowGold;
//dp Problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12865 {
    static int N, K;//N 물건수, K 허용가능한 무게
    static int []dpTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dpTable = new int[K + 1];
        int[] weight = new int[N + 1];
        int[] worth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            worth[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = K; j-weight[i]>=0; j--) {
                dpTable[j] = Math.max(dpTable[j], dpTable[j - weight[i]] + worth[i]);
            }
            }
        System.out.println(dpTable[K]);

    }


    }


