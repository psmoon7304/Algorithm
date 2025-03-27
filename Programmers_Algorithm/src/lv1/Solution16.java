package lv1;

public class Solution16 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++) {
            int gift = 0; // 0 : 상품 받을 수 있음 / 1: 받을 수 없음
            schedules[i] += 10;
            if(schedules[i] % 100 > 59) schedules[i] += 40;
            for(int j = 0; j < 7; j++) {
                if(j + startday == 6 || j + startday == 7 || j + startday == 13) continue;
                if(schedules[i] < timelogs[i][j]) {
                    gift = 1;
                    break;
                }
            }
            if(gift == 0) {
                answer++;
            }
        }
        return answer;
    }
}
