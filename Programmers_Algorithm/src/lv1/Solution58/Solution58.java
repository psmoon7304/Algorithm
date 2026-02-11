package lv1.Solution58;

public class Solution58 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < n; i++) answer[i] = (long)x * (1+i);
        return answer;
    }
}
