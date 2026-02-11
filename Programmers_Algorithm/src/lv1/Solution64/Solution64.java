package lv1.Solution64;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution64 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int rank = 0, zeroCount = 0;
        for(int i : lottos) {
            if(i == 0) zeroCount++;
            else if(list.contains(i)) rank++;
        }
        if(rank == 0) answer[1] = 6;
        else answer[1] = 7 - rank;
        if(rank + zeroCount > 6) answer[0] = 1;
        else if (rank == 0 && zeroCount == 0) answer[0] = 6;
        else answer[0] = 7 - (rank + zeroCount);
        return answer;
    }
}
