package lv1.Solution41;

import java.util.ArrayList;

public class Solution41 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i : arr) {
            if(stack.isEmpty()) stack.add(i);
            else if(stack.get(stack.size() - 1) != i) {
                stack.add(i);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = stack.get(i);
        return answer;
    }
}
