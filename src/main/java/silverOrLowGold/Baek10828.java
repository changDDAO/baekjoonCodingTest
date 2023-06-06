package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[10000];
        StringBuilder sb = new StringBuilder();
        int top = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.startsWith("push")) {
                String[] temp = s.split(" ");
                int value = Integer.parseInt(temp[1]);
                stack[top]=value;
                top++;
            } else if (s.equals("pop")) {
                top--;
                if (top >= 0) {
                    if(stack[top]!=0)
                    sb.append(stack[top] + "\n");
                    else sb.append(-1 + "\n");
                } else {
                    sb.append(-1 + "\n");
                    top=0;
                }
            }
                else if (s.equals("top")) {
                    if(top==0)sb.append(-1+"\n");
                    else sb.append(stack[top-1] + "\n");
            } else if (s.equals("empty")) {
                if(top==0)sb.append(1+"\n");
                else sb.append(0 + "\n");
            }
            else if(s.equals("size")) sb.append((top) + "\n");
        }
        System.out.println(sb.toString());
    }
}
