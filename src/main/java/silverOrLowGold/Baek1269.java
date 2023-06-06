package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Baek1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        String s = br.readLine();
        Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt)
                .forEach(o->setA.add(o));
        s = br.readLine();
        Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt)
                .forEach(o->setB.add(o));

        Iterator<Integer> iteratorA = setA.iterator();
        Iterator<Integer> iteratorB = setB.iterator();
        int cnt = 0;
        while (iteratorB.hasNext()) {
            int temp = iteratorB.next();
            if(setA.contains(temp))cnt++;
        }
        int answer = setA.size()-cnt;
        cnt=0;
        while (iteratorA.hasNext()) {
            int temp = iteratorA.next();
            if(setB.contains(temp))cnt++;
        }
        answer+= setB.size()-cnt;

        System.out.println(answer);
    }
}
