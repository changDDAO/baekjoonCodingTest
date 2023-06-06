package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int crossCount =1, prevSum =0;
        while (true) {
            if (X <= crossCount + prevSum) {
                if (crossCount % 2 == 1) {
                    //분자가 큰거부터 먼저시작
                    System.out.println(crossCount - (X - prevSum - 1) + "/" + (X - prevSum));
                    break;
                } else {
                    System.out.println(X - prevSum + "/" + (crossCount - (X - prevSum - 1)));
                    break;
                }

            } else {
                prevSum+=crossCount++;
            }
        }

    }
}
