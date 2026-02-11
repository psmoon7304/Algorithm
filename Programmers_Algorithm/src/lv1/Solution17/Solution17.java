package lv1.Solution17;

public class Solution17 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(bill[0],bill[1]) > Math.min(wallet[0], wallet[1]) || Math.max(bill[0],bill[1]) > Math.max(wallet[0], wallet[1])) {
            answer++;
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
        }
        return answer;
    }
}

/* 초기 작성 코드
public class Solution17 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int tempSize = 0;
        if(bill[0] > bill[1]) {
            tempSize = bill[0];
            bill[0] = bill[1];
            bill[1] = tempSize;
        }
        if(wallet[0] > wallet[1]) {
            tempSize = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = tempSize;
        }
        while(bill[0] > wallet[0] || bill[1] > wallet[1]) {
            answer++;
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            if(bill[0] > bill[1]) {
                tempSize = bill[0];
                bill[0] = bill[1];
                bill[1] = tempSize;
            }
            if(wallet[0] > wallet[1]) {
                tempSize = wallet[0];
                wallet[0] = wallet[1];
                wallet[1] = tempSize;
            }
        }
        return answer;
    }
}
 */
