package lv2.Solution5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    static int[] fees, answer;
    static String[] records;
    static HashMap<String, Integer> inoutLog; // Key : 차량번호 / Value : 주차시간
    static HashMap<String, Integer> carPay;

    static void serviceRun() {
        for(int act = 0; act < records.length; act++) {
            String[] inoutInfo = records[act].split(" ");
            int time = changeTime(inoutInfo[0]); // 입/출차 시간을 분으로 변환
            String carNum = inoutInfo[1];

            if(inoutLog.containsKey(carNum)) {
                carOut(carNum, time);
            } else {
                inoutLog.put(carNum, time); // 차량이 로그에 없는 것으로 번호를 키로, 입차시간을 벨류로 추가
            }
        }
    }

    static void carOut(String carNum, int outTime) {
        // 1. 차량의 번호의 벨류 값을 통해서 주차시간 계산 ( outTime - MapValue )
        int totalTime = outTime - inoutLog.get(carNum);
        // 2. 계산된 값을 차량 별 누적 주차시간에 합산
        carPay.putIfAbsent(carNum, 0);
        carPay.put(carNum, (carPay.get(carNum) + totalTime));
        System.out.println("totalTime : " + carPay.getOrDefault(carNum, 0));
        // 3. inoutLog에서 carNum의 값 삭제
        inoutLog.remove(carNum);
    }

    static int getPay(int time) {
        // 기본 시간 / 기본 금액 / 단위 시간 / 단위 금액
        if(time <= fees[0]) return fees[1];
        return fees[1] + (int)(Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3]);
    }

    static int changeTime(String time) {
        String[] temp = time.split(":");
        return ( Integer.parseInt(temp[0]) * 60 ) + Integer.parseInt(temp[1]);
    }

    static void getAnswer() {
        answer = new int[carPay.size()];
        String[] carList = new String[carPay.size()];

        int pointer = 0;
        for(String carNum : carPay.keySet()) {
            carList[pointer++] = carNum;
        }
        Arrays.sort(carList);
        for(Map.Entry<String,Integer> entry : carPay.entrySet()) {
            for(int i = 0; i < carList.length; i++) {
                if(carList[i].equals(entry.getKey())) {
                    System.out.println("Answer : " + entry.getValue());
                    answer[i] = getPay(entry.getValue());
                }
            }
        }
    }

    static void init(int[] f, String[] r) {
        fees = f.clone();
        records = r.clone();
        inoutLog = new HashMap<>();
        carPay = new HashMap<>();
    }

    public int[] solution(int[] f, String[] r) {
        init(f, r); // 전역 변수로 사용하기 위한 파라미터 초기화.
        serviceRun();
        int maxTime = changeTime("23:59");
        for(String key : new HashMap<>(inoutLog).keySet()) {
            carOut(key, maxTime);
        }
        getAnswer();
        return answer;
    }
}
