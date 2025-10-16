import java.util.*;

class Solution {
    static HashMap<String, String> info = new HashMap<>();
    static HashMap<String, Integer> record = new HashMap<>();
    static int[] answer;

    static void getMoney(String[] enroll, String name, int amount) {
        int totalMoney = amount * 100;

        while(true) {
            record.put(name, record.get(name) + (totalMoney - (totalMoney / 10)));
            name = info.get(name);
            totalMoney /= 10;
            if(name.equals("-")) break;
            if(totalMoney == 0) break;
        }
    }

    static void update(String[] enroll) {
        for(int i = 0; i < enroll.length; i++) answer[i] += record.get(enroll[i]);
    }

    static void init(String[] enroll, String[] referral) {
        answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            info.put(enroll[i], referral[i]);
            record.put(enroll[i], 0);
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        init(enroll, referral);
        for(int i = 0; i < seller.length; i++) {
            getMoney(enroll, seller[i], amount[i]);
        }
        update(enroll);
        return answer;
    }
}