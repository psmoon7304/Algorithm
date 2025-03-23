package lv1;

public class Solution3 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Index = 0, cards2Index = 0;
        if(!cards1[cards1Index].equals(goal[0]) && !cards2[cards2Index].equals(goal[0])) return "No";
        for(String goalWord : goal) {
            if(cards1.length != cards1Index && cards1[cards1Index].equals(goalWord)) {
                cards1Index++;
            } else if(cards2.length != cards2Index && cards2[cards2Index].equals(goalWord)) {
                cards2Index++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
