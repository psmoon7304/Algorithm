package lv1.Solution53;

import java.util.HashMap;

public class Solution53 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String name : completion) map.put(name, map.getOrDefault(name, 0) + 1);
        for(String name : participant) {
            if(!map.containsKey(name)) return name;
            if(map.get(name) > 1) map.put(name, map.get(name) - 1);
            else map.remove(name);
        }
        return "";
    }
}
