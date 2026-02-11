package lv1.Solution62;

import java.util.HashMap;
public class Solution62 {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> userScores = new HashMap<>();
        int[] choicesScore = {3,2,1,0,1,2,3};
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < survey.length; i++) {
            if(choices[i] < 4) {
                userScores.put(survey[i].charAt(0), userScores.getOrDefault(survey[i].charAt(0), 0) + choicesScore[choices[i] - 1]);
            } else if(choices[i] > 4) {
                userScores.put(survey[i].charAt(1), userScores.getOrDefault(survey[i].charAt(1), 0) + choicesScore[choices[i] - 1]);
            }
        }
        if(userScores.getOrDefault('R',0) < userScores.getOrDefault('T',0)) {
            answer.append("T");
        } else {
            answer.append("R");
        }

        if(userScores.getOrDefault('F',0) > userScores.getOrDefault('C',0)) {
            answer.append("F");
        } else {
            answer.append("C");
        }

        if(userScores.getOrDefault('M',0) > userScores.getOrDefault('J',0)) {
            answer.append("M");
        } else {
            answer.append("J");
        }

        if(userScores.getOrDefault('N',0) > userScores.getOrDefault('A',0)) {
            answer.append("N");
        } else {
            answer.append("A");
        }
        return answer.toString();
    }
}
