package lv3.Solution8;

import java.io.*;
import java.util.*;

public class Solution8 {
    static int firstBus, tSize;
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    private static int changeTime(String time) {
        String[] timeArray = time.split(":");
        return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
    }

    private static String rChangeTime(int time) {
        sb.setLength(0);
        int h = time / 60, m = time % 60;
        if(h < 10) sb.append("0").append(h).append(":");
        else sb.append(h).append(":");

        if(m < 10) sb.append("0").append(m);
        else sb.append(m);

        return sb.toString();
    }

    private static int getResult(int n, int t, int m) {
        int lastNum = 0, count;
        if(deque.peek() > firstBus + ((n - 1) * t)) return firstBus + ((n - 1) * t);

        for(int i = 0; i < n; i++) {
            count = 0;
            for(int j = 0; j < m; j++) {
                if(deque.isEmpty()) return firstBus +  ((n - 1) * t);
                if(deque.peek() > firstBus + (i * t)) break;
                lastNum = deque.poll();
                count++;
            }
        }
        if(!deque.isEmpty() && lastNum < firstBus +  ((n - 1) * t) - 1 && deque.peek() > firstBus +  ((n - 1) * t)) return firstBus +  ((n - 1) * t);
        return lastNum - 1;
    }

    private static void init(String[] timetable) {
        tSize = timetable.length;
        int[] temp = new int[tSize];
        for(int i = 0; i < tSize; i++) temp[i] = changeTime(timetable[i]);
        firstBus = changeTime("09:00");
        Arrays.sort(temp);
        for(int value : temp) deque.offer(value);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        init(timetable);

        return rChangeTime(getResult(n, t, m));
    }
}
