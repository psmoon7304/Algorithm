package Baekjoon.Silver.Main_1244;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int switchNum;
    static int[] switchStatus;

    private static void man(int num) {
        for(int i = num; i <= switchNum; i += num) switchStatus[i] *= -1;
    }

    private static void woman(int num) {
        int start = num, end = num;
        while(start > 1 && end < switchNum) {
            if(switchStatus[start - 1] != switchStatus[end + 1]) break;
            start--;
            end++;
        }
        if(start <= 0) start = 1;
        if(end > switchNum) end = switchNum;
        for(int i = start; i <= end; i++) switchStatus[i] *= -1;
    }

    private static void init() throws Exception {
        switchNum = Integer.parseInt(br.readLine().trim());
        switchStatus = new int[switchNum + 1];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= switchNum; i++) switchStatus[i] = Integer.parseInt(st.nextToken()) == 0 ? -1 : 1;
    }

    public static void main(String[] args) throws Exception {
        init();
        int player = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < player; i++) {
            st = new StringTokenizer(br.readLine().trim());
            if(Integer.parseInt(st.nextToken()) == 1) man(Integer.parseInt(st.nextToken()));
            else woman(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1; i <= switchNum; i++) {
            sb.append(switchStatus[i] == -1 ? 0 : 1).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
