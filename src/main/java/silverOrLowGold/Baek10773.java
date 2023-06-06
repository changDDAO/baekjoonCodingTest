package silverOrLowGold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int money = Integer.parseInt(br.readLine());
            if(money!=0) stack.push(money);
            else{
                stack.pop();

            }
        }
        int answer = stack.stream().mapToInt(Integer::intValue)
                .sum();
        System.out.println(answer);
        }
}
