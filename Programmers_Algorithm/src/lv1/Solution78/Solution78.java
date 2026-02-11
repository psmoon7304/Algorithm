package lv1.Solution78;

import java.util.HashMap;

public class Solution78 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] temp = new double[N];
        int player = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i : stages) map.put(i, map.getOrDefault(i,0.0) + 1);
        for(int i = 0; i < N; i++) {
            if(player == 0) {
                temp[i] = 0.0;
                continue;
            }
            temp[i] = map.getOrDefault(i + 1, 0.0) / player;
            player -= map.getOrDefault(i + 1, 0.0);
        }
        for(int i = 0; i < N; i++) {
            double value = -1.0;
            for(int j = 0; j < N; j++) {
                if(temp[j] > value) {
                    value = temp[j];
                }
            }
            for(int j = 0; j < temp.length; j++) {
                if(temp[j] == value) {
                    answer[i] = j + 1;
                    temp[j] = -1.0;
                    break;
                }
            }
        }
        return answer;
    }
}
