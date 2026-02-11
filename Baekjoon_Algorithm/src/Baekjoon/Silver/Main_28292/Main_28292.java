package Baekjoon.Silver.Main_28292;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_28292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    private static int antSeq(int num) {
        String nowNum = "1";
        if(num == 1) return 1;

        for(int i = 1; i < num; i++) {
            sb = new StringBuilder();
            char lastChar = nowNum.charAt(0);
            int count = 1;
            for(int j = 1; j < nowNum.length(); j++) {
                if(nowNum.charAt(j) != lastChar) {
                    if(count == 3) return 3;
                    sb.append(lastChar).append(count);
                    lastChar = nowNum.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(lastChar).append(count);
            nowNum = sb.toString();
        }
        return Integer.parseInt(nowNum);
    }

    private static int getResult(int num) {
        int answer = 0;
        while(num / 10 != 0) {
            answer = Math.max(answer, num % 10);
            if(answer == 3) return 3;
            num /= 10;
        }
        return Math.max(answer, num % 10);
    }
    public static void main(String[] args) throws Exception {
        int num = antSeq(Integer.parseInt(br.readLine().trim()));
        System.out.println(getResult(num));
    }
}