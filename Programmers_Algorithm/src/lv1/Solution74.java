package lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution74 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> list = Arrays.stream(lost).boxed().collect(Collectors.toList());
        for(int i = 0; i < reserve.length; i++) {
            if (list.contains(reserve[i])) {
                list.set(list.indexOf(reserve[i]), -1);
                reserve[i] = -1;
                answer++;
            }
        }
        for(int i : reserve) {
            if(i == -1) continue;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == -1) continue;
                if(list.get(j) == i - 1) {
                    list.set(j, -1);
                    answer++;
                    break;
                } else if(list.get(j) == i + 1) {
                    list.set(j, -1);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
