package lv1;

import java.util.ArrayList;

public class Solution45 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> alphabet = new ArrayList<>();
        int nowPos = 0;
        for(int i = 97; i < 123; i++) alphabet.add(i);
        for(int skipChar : skip.toCharArray()) alphabet.remove(Integer.valueOf(skipChar));
        for(int sChar : s.toCharArray()) {
            nowPos = alphabet.indexOf(sChar) + index;
            if(nowPos > alphabet.size() - 1) nowPos %= alphabet.size();
            answer.append((char)(int)alphabet.get(nowPos));
        }
        return answer.toString();
    }
}
