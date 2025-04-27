package lv2;

import java.util.ArrayList;

public class Solution1 {
    public int solution(int[] players, int m, int k) {
        int answer = 0, nowServer = 1;
        ArrayList<Integer[]> returnTime = new ArrayList<>();
        for(int i = 0; i < players.length; i++) {
            if(!returnTime.isEmpty() && returnTime.get(0)[0] == i) {
                nowServer -= returnTime.get(0)[1];
                returnTime.remove(0);
            }
            if(players[i] >= m * nowServer) {
                int temp = (players[i] - (m * nowServer)) / m + 1;
                answer += temp;
                nowServer += temp;
                Integer[] returnTemp = {i + k, temp};
                returnTime.add(returnTemp);
            }
        }
        return answer;
    }
}
