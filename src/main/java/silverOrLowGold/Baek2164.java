package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int answer= 0;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        if (dq.size() == 1) {
            System.out.println(dq.peek());
            return;
        }
        while (true) {
            dq.pollFirst();
            if (dq.size() == 1) {
                answer= dq.poll();
                break;
            }
            Integer next = dq.pollFirst();
            dq.add(next);
        }
        System.out.println(answer);

    }
}
