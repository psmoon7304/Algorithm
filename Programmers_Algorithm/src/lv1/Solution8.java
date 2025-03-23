package lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution8 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int score;
        Map<String, Integer> nameMap = new HashMap<>();
        for(int i = 0; i < name.length; i++) nameMap.put(name[i],yearning[i]);

        for(int i = 0; i < photo.length; i++) {
                score = 0;
            for(int j = 0; j < photo[i].length; j++) if(nameMap.get(photo[i][j]) != null) score += nameMap.get(photo[i][j]);
            answer[i] = score;
        }
        return answer;
    }
}
