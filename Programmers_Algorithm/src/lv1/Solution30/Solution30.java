package lv1.Solution30;

import java.util.HashMap;
import java.util.Map;

public class Solution30 {
    public int solution(String s) {
        int answer = 0, anotherLetter = 0;
        char tempLetter = ' ';
        Map<Character, Integer> letter = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(letter.isEmpty()) {
                tempLetter = c;
                letter.put(tempLetter, 1);
            } else if(letter.containsKey(c)) {
                letter.put(c, letter.get(c) + 1);
            } else {
                anotherLetter++;
                if(letter.get(tempLetter) == anotherLetter) {
                    answer++;
                    anotherLetter = 0;
                    letter.clear();
                }
            }
        }
        if(!letter.isEmpty()) answer++;
        return answer;
    }
}
