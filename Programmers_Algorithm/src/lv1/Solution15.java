package lv1;

public class Solution15 {
    public String solution(int[] food) {
        int answerSize = 0, pointer = 0;
        for(int i : food) {
            answerSize += i / 2;
        }
        char[] answer = new char[answerSize * 2 + 1];

        for(int i = 0; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                answer[pointer] = (char)(i + '0');
                answer[answer.length - 1 - pointer] = (char)(i + '0');
                pointer++;
            }
        }
        answer[pointer] = '0';
        return String.valueOf(answer);
    }
}
