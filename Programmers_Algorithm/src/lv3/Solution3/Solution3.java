package lv3.Solution3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o->o[1]));
        int answer = 1;
        int range = routes[0][1];

        for(int i = 1; i < routes.length; i++) {
            if(range < routes[i][0]) {
                range = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
