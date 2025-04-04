package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution31 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, ArrayList<String>> reportList = new HashMap<>();
        for(String name : id_list) {
            reportCount.put(name, 0);
            reportList.putIfAbsent(name, new ArrayList<>());
        }

        for(String reportInfo : report) {
            String[] info = reportInfo.split(" ");
            if(!(reportList.get(info[1]).contains(info[0]))) {
                reportList.get(info[1]).add(info[0]);
                reportCount.put(info[1], reportCount.get(info[1]) + 1);
            }
        }
        for(String name : id_list) {
            if(reportCount.get(name) >= k) {
                for(String msgName : reportList.get(name)) {
                    answer[Arrays.asList(id_list).indexOf(msgName)]++;
                }
            }
        }
        return answer;
    }
}
