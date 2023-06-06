package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] answerList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cnt = Integer.parseInt(st.nextToken());//나보다 키가 큰 왼쪽편에 있는 사람의 수
            for (int j = 0; j < N; j++) {
                if (answerList[j] == 0 && cnt == 0) {
                    answerList[j] = i;
                    break;
                } else if (answerList[j] == 0) {
                    cnt--;
                }
            }
        }
        for(int v: answerList)
        sb.append(v+" ");
        System.out.println(sb.toString());


        }




}
