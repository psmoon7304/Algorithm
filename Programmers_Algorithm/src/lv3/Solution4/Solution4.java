package lv3.Solution4;

public class Solution4 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) return new int[] {-1};

        int value = s / n + 1;
        int minus = s % n;
        for(int i = 0; i < n - minus; i++) {
            answer[i] = value - 1;
        }
        for(int i = n - minus; i < n; i++) {
            answer[i] = value;
        }

        return answer;
    }
}
