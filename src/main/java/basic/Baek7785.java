package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> nameList = new ArrayList<>();
        HashMap<String, Integer> enterMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String name = st.nextToken();
            Integer check = st.nextToken().equals("enter")?1:-1;
            enterMap.put(name, enterMap.getOrDefault(name,0)+check);
        }
        Iterator<Map.Entry<String, Integer>> iterator = enterMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue()>0) nameList.add(entry.getKey());
        }
        Collections.sort(nameList,Comparator.reverseOrder());
        for (String name : nameList) {
            sb.append(name + "\n");
        }
        System.out.println(sb.toString());

    }
}
