package lv1;

public class Solution23 {
    public int solution(int n, int m, int[] section) {
        int answer = 1, lastDrawing = section[0] + m - 1;
        for(int i = 1; i < section.length; i++) {
            if(lastDrawing < section[i]) {
                lastDrawing = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}
