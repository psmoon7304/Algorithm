package lv1.Solution68;

public class Solution68 {
    public int solution(int n) {
        int answer = 0;
        while(n / 10 != 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer += n % 10;
    }
}
