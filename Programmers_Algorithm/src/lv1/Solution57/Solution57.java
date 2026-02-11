package lv1.Solution57;

import java.util.HashMap;

public class Solution57 {
    boolean solution(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) if(c == 'p' || c == 'y') map.put(c,map.getOrDefault(c, 0) + 1);
        if(map.size() == 0 || map.get('p') == map.get('y')) return true;
        return false;
    }
}
