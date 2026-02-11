package lv2.Solution3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int solution(int[][] targets) {
        int answer = 0, nowPos = 0;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for(int i = 0; i < targets.length; i++) {
            if(nowPos <= targets[i][0]) {
                nowPos = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
