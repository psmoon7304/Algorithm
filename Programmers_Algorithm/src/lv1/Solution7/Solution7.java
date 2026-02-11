package lv1.Solution7;

public class Solution7 {
    public int solution(int a, int b, int n) {
        int answer = 0, temp = 0;
        while(n / a != 0) {
            answer += n / a * b;
            temp = n % a;
            n = n / a * b;
            n += temp;
        }
        return answer;
    }
}
