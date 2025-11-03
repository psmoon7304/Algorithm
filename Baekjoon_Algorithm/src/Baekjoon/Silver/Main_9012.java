package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine().trim());
        for(int tcase = 0; tcase < T; tcase++) {
            int isVPS = 0;
            char[] value = br.readLine().toCharArray();
            for(char text : value) {
                if(text == '(') isVPS++;
                else isVPS--;
                if(isVPS < 0) break;
            }
            if(isVPS == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb.toString());
    }
}
