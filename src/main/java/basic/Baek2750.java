package basic;

import java.io.IOException;
import java.util.*;

public class Baek2750 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int v = sc.nextInt();
            numList.add(v);
        }
        int[] nums = numList.stream().mapToInt(Integer::intValue).sorted().distinct().toArray();
        for (int num : nums) {
            System.out.println(num);
        }
    }

    }

