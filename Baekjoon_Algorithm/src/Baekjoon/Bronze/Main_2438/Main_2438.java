package Baekjoon.Bronze.Main_2438;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2438 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int high = Integer.parseInt(br.readLine());

        for(int i = 1; i <= high; i++) {
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
