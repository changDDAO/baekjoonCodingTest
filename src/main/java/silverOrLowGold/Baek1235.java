package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1235 {
    public static void main(String[] args) throws IOException {
        List<String> stringList = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stringList.add(br.readLine());
        }
        int len= stringList.get(0).length();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < stringList.size(); j++) {
                stringSet.add(stringList.get(j).substring(len - i));
            }
            if(stringSet.size()==N){ answer =i;
            break;
            }
            stringSet.clear();

        }
        System.out.println(answer);





    }
}
