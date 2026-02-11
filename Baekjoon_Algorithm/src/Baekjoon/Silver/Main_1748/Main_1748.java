package Baekjoon.Silver.Main_1748;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1748 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String stringNum = br.readLine().trim();
        int numLength = stringNum.length() - 1;
        int num = Integer.parseInt(stringNum);
        int answer = 0;
        for(int i = 0; i < numLength; i++) {
            int temp = (int)(Math.pow(10, i) * 9);
            num -= temp;
            answer += temp * (i + 1);
        }
        System.out.print(answer + (num * (numLength + 1)));
    }
}
