package lv1.Solution28;

public class Solution28 {
    public int solution(int[] numbers) {
        int answer = 45; // 1~9 더한 값
        for(int i : numbers) {
            answer -= i;
        }
        return answer;
    }
}
