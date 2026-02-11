package lv1.Solution4;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> charOrder = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(charOrder.get(s.charAt(i)) == null) {
                charOrder.put(s.charAt(i), i);
                answer[i] = -1;
            } else {
                answer[i] = i - charOrder.get(s.charAt(i));
                charOrder.put(s.charAt(i), i);
            }
        }
        return answer;
    }
}