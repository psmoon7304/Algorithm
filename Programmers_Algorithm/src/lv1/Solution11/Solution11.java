package lv1.Solution11;

public class Solution11 {
    public int solution(int n) {
        int answer = n + 1;
        if(n < 2) return n;
        for(int i = 2; i <= (int)Math.ceil((double)n/2); i++) {
            if(n % i == 0) answer += i;
        }
        return answer;
    }
}
