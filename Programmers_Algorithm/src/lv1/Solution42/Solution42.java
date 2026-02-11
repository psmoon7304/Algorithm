package lv1.Solution42;

import java.util.HashMap;

public class Solution42 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> xMap = new HashMap<>();
        HashMap<Character, Integer> yMap = new HashMap<>();
        for(char x : X.toCharArray()) xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        for(char y : Y.toCharArray()) yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        for(int i = 9; i >= 0; i--) {
            char nowNum = (char)(i + '0');
            if(xMap.containsKey(nowNum) && yMap.containsKey(nowNum)) {
                int count = Math.min(xMap.get(nowNum),yMap.get(nowNum));
                for(int j = 0; j < count; j++) answer.append(nowNum);
            }
        }
        if(answer.length() == 0) return "-1";
        if(answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}
