package lv1;

import java.util.ArrayList;

public class Solution75 {
    public int solution(String dartResult) {
        int answer = 0, scoreNum = 0, scoreBonus = 0, scoreOption = 1;
        ArrayList<Integer> tempScore = new ArrayList<>();
        char[] dart = dartResult.toCharArray();
        for(int i = 0; i < dart.length; i++) {
            if(dart[i] - '0' >= 0 && dart[i] - '0' <= 9) {
                if(dart[i] - '0' == 1 && dart[i+1] - '0' == 0) {
                    scoreNum = 10;
                    i++;
                    continue;
                }
                else scoreNum = dart[i] - '0';
            }
            else if(dart[i] == 'S') scoreBonus = 1;
            else if(dart[i] == 'D') scoreBonus = 2;
            else if(dart[i] == 'T') scoreBonus = 3;
            else if(dart[i] == '#') scoreOption = -1;
            else if(dart[i] == '*') scoreOption = 2;

            if((i + 1 < dart.length && (dart[i + 1] - '0' >= 0 && dart[i + 1] - '0' <= 9)) || i + 1 == dart.length) {
                if(scoreOption == 2 && tempScore.size() > 0) tempScore.set(tempScore.size() - 1, tempScore.get(tempScore.size() - 1) * scoreOption);
                tempScore.add((int)Math.pow(scoreNum, scoreBonus) * scoreOption);
                scoreNum = 0;
                scoreBonus = 0;
                scoreOption = 1;
            }
        }
        for(int i : tempScore) answer += i;
        return answer;
    }
}
