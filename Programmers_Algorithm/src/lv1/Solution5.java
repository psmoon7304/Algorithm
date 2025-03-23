package lv1;

import java.util.Arrays;

public class Solution5 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int boxPointer = score.length;
        int box = score.length / m;
        if(box == 1) {
            return score[boxPointer - m] * m;
        }
        for(int i = 0; i < box; i++) {
            answer += score[boxPointer - m] * m;
            boxPointer -= m;
        }
        return answer;
    }
}
