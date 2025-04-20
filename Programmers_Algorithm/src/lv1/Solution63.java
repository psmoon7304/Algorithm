package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution63 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i : arr) {
            if(i % divisor == 0) list.add(i);
        }
        if(list.isEmpty()) return new int[] {-1};
        return list.stream().mapToInt(i -> i).toArray();
    }
}
