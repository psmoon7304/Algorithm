package lv1;
import java.util.Arrays;
import java.util.HashMap;

public class Solution81 {
    public int solution(String[] friends, String[] gifts) {
        String[] friendsIndex = new String[friends.length]; // HashMap 안에 있는 배열의 인덱스 번호를 이용하기 위해 사용
        int[] giftsPoint = new int[friends.length]; // 선물지수 기록용
        HashMap<String,Integer[]> giftInfo = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < friends.length; i++) { // HashMap 초기 값 지정
            Integer[] tempArray = new Integer[friends.length];
            Arrays.fill(tempArray, 0);
            friendsIndex[i] = friends[i];
            giftInfo.putIfAbsent(friends[i], tempArray);
        }

        for(String info : gifts) { // 유저 A의 이름을 키값으로 나머지 유저들에게 선물한 이력을 기록 / 배열의 순서는 friendsIndex의 값과 동일
            String[] tempInfo = info.split(" ");
            giftInfo.get(tempInfo[0])[Arrays.asList(friendsIndex).indexOf(tempInfo[1])]++;
        }

        for(int i = 0; i < friendsIndex.length; i++) { // 선물지수 계산을 위해 사용
            int send = 0,receive = 0;
            for(int j = 0; j < friendsIndex.length; j++) {
                send += giftInfo.get(friendsIndex[i])[j];
                receive += giftInfo.get(friendsIndex[j])[i];
            }
            giftsPoint[i] = send - receive;
        }

        for(int i = 0; i < friendsIndex.length; i++) { // A가 몇명에게 선물을 받는지 확인
            int temp = 0;
            for(int j = 0; j < friendsIndex.length; j++) {
                if(i == j) continue;
                if(giftInfo.get(friendsIndex[i])[j] > giftInfo.get(friendsIndex[j])[i]) {
                    temp++;
                } else if(giftInfo.get(friendsIndex[i])[j] == giftInfo.get(friendsIndex[j])[i] && giftsPoint[i] > giftsPoint[j]) {
                    temp++;
                }
            }
            if(answer < temp) answer = temp;
        }
        return answer;
    }
}
