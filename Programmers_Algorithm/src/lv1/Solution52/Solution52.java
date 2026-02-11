package lv1.Solution52;

import java.util.Arrays;

public class Solution52 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int pos = 0;
        for(int[] i : commands) {
            int[] temp = Arrays.copyOfRange(array, i[0] - 1, i[1]);
            Arrays.sort(temp);
            answer[pos] = temp[i[2] - 1];
            pos++;
        }
        return answer;
    }
}
