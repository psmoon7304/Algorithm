package Baekjoon.Bronze.Main_2851;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int answer = Integer.MIN_VALUE;
    static int[] prefixSum = new int[11];

    public static void main(String[] args) throws Exception {
        for(int i = 1; i <= 10; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(br.readLine().trim());
            if(prefixSum[i] >= 100) {
                int tempA = Math.abs(100 - prefixSum[i - 1]);
                int tempB = Math.abs(100 - prefixSum[i]);
                if(tempA == tempB || tempA > tempB) {
                    answer = prefixSum[i];
                    break;
                }
                else {
                    answer = prefixSum[i - 1];
                    break;
                }
            }
        }
        if(answer == Integer.MIN_VALUE) answer = prefixSum[10];
        System.out.println(answer);
    }
}
