package basic;
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
        for (int i = 0; i < N; i++) {
            //dp 초기화하기
             st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int happyPoint = Integer.parseInt(st.nextToken());
            if(weight<K)dpTable[weight]=happyPoint;
        }
        for (int i = 1; i <= K; i++) {
            int sum = 0;
            for (int j = i + 1; j <= K; j++) {
                sum = i+j;
                if (sum <= K && dpTable[K] < dpTable[i] + dpTable[j]) {
                    dpTable[K]=dpTable[i] + dpTable[j];
                }

            }
            }
        System.out.println(dpTable[K]);

    }


    }


