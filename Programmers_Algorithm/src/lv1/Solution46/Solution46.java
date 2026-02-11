package lv1.Solution46;

import java.util.Arrays;

public class Solution46 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rank = new int[k];
        int lowScore = 2001;
        for(int i = 0; i < score.length; i++) {
            if(i < k) {
                rank[i] = score[i];
                if(rank[i] < lowScore) lowScore = rank[i];
            } else {
                Arrays.sort(rank);
                if(rank[0] < score[i]) {
                    rank[0] = score[i];
                    Arrays.sort(rank);
                    lowScore = rank[0];
                }
            }
            answer[i] = lowScore;
        }
        return answer;
    }
}


//3	[10, 100, 20, 150, 1, 100, 200]	[10, 10, 10, 20, 20, 100, 100]