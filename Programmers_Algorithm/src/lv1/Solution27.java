package lv1;

import java.util.Arrays;

public class Solution27 {
    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int answer = 0, pointer = 0;

        for(String s : babbling) {
            if(Arrays.asList(word).contains(s)) {
                answer++;
                continue;
            }
            for(String w : word) {
                s = s.replace(w, " ");
            }
            s = s.replace(" ", "");
            if(s.length() == 0) answer++;
        }
        return answer;
    }
}
