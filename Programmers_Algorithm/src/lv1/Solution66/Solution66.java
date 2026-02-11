package lv1.Solution66;

public class Solution66 {
    public int solution(int n) {
        int answer = 1, check = 0;
        for(int i = 3; i <= n; i++) {
            check = 0;
            if(i % 2 == 0) continue;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    check = 1;
                    break;
                }
            }
            if(check == 0) answer++;
        }
        return answer;
    }
}
