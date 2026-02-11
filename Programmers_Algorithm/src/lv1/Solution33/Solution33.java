package lv1.Solution33;

public class Solution33 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 1; i <= count; i++) answer += (long)price * i;
        if(money - answer >= 0) return 0;
        return answer - money;
    }
}
