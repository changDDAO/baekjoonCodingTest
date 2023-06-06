package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1620 {
    static int n, m;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> sMap = new HashMap<>();
        HashMap<Integer, String> iMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            sMap.put(s,i);
            iMap.put(i,s);
        }


        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (isNum(s)) {
               sb.append(iMap.get(Integer.parseInt(s))+"\n");

            } else sb.append(sMap.get(s) + "\n");
        }
        System.out.println(sb.toString());


    }
    static boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }





}
