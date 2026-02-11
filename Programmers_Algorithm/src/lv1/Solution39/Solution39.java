package lv1.Solution39;

public class Solution39 {
    public long solution(int a, int b) {
        long answer = 0;
        for(int i = Math.min(a,b); i <= Math.max(a,b); i++) answer += i;
        return answer;
    }
}
