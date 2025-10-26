package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_20207 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int sCount = Integer.parseInt(br.readLine());
        int[] calendar = new int[366];
        Arrays.fill(calendar, 0);

        for(int i = 0; i < sCount; i++) {
            String[] inputData = br.readLine().split(" ");
            int start = Integer.parseInt(inputData[0]);
            int end = Integer.parseInt(inputData[1]);
            for(int j = start; j <= end; j++) {
                calendar[j]++;
            }
        }
        int x = 0, y = 1;
        for(int i = 0; i < calendar.length; i++) {
            if(calendar[i] > 0) {
                x++;
                y = Math.max(y, calendar[i]);
            } else {
                answer += x * y;
                x = 0;
                y = 1;
            }
        }
        answer += x * y;
        System.out.println(answer);
    }
}
