package lv1;

import java.util.HashMap;

public class Solution44 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int clickCount = 0;
        HashMap<Character, Integer> keys = new HashMap<>();

        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char tempKey = key.charAt(i);
                if(!(keys.containsKey(tempKey))) keys.put(tempKey, i + 1);
                else {
                    if(keys.get(tempKey) > i + 1) keys.replace(tempKey, i + 1);
                }
            }
        }

        for(int i = 0; i < targets.length; i++) {
            clickCount = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                if(keys.get(targets[i].charAt(j)) != null) {
                    clickCount += keys.get(targets[i].charAt(j));
                } else {
                    clickCount = 0;
                    break;
                }
            }
            if(clickCount == 0) answer[i] = -1;
            else answer[i] = clickCount;
        }
        return answer;
    }
}
