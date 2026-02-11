package lv1.Solution67;

public class Solution67 {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int[] answer = new int[num.length()];
        for(int i = 0; i < num.length(); i++) answer[answer.length - i - 1] = num.charAt(i) - '0';
        return answer;
    }
}
