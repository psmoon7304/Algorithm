package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[] roomNum;
    static int[] numbers = new int[10];
    static int maxNum;

    public static void main(String[] args) throws Exception {
        roomNum = br.readLine().split("");
        for(String i : roomNum) {
            int num = Integer.parseInt(i);
            numbers[num]++;
            if(num == 6 || num == 9) continue;
            maxNum = Math.max(maxNum, numbers[num]);
        }
        System.out.print((int)Math.max(maxNum, Math.ceil((double)(numbers[6] + numbers[9]) / 2)));
    }
}
