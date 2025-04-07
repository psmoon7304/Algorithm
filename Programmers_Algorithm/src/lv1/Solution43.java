package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution43 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] todayArray = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for(String term : terms) termsMap.put(term.charAt(0), Integer.parseInt(term.substring(2)));

        for(int i = 0; i < privacies.length; i++) {
            char privaciesTerm = privacies[i].charAt(privacies[i].length() - 1);
            int[] privaciesDate = Arrays.stream(privacies[i].substring(0, privacies[i].length() - 2).split("\\.")).mapToInt(Integer::parseInt).toArray();
            privaciesDate[1] += termsMap.get(privaciesTerm);
            if(privaciesDate[1] % 12 != 0) {
                privaciesDate[0] += privaciesDate[1] / 12;
                privaciesDate[1] = privaciesDate[1] % 12;
            } else {
                privaciesDate[0] += privaciesDate[1] / 12 - 1;
                privaciesDate[1] = 12;
            }
            if(todayArray[0] < privaciesDate[0]) continue;
            else if((todayArray[0] > privaciesDate[0]) || (todayArray[1] > privaciesDate[1]) || ((todayArray[1] == privaciesDate[1] && todayArray[2] >= privaciesDate[2]))) {
                answer.add(i + 1);
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) result[i] = answer.get(i);
        return result;
    }
}
