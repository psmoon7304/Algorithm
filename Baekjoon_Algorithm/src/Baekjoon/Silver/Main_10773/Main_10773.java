package Baekjoon.Silver.Main_10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10773 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] prefixSum;
    static int K, pointer = 1;

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine().trim());
        prefixSum = new int[K + 1];
        for(int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine().trim());
            if(value == 0) prefixSum[--pointer] = 0;
            else {
                prefixSum[pointer] = prefixSum[pointer - 1] + value;
                pointer += 1;
            }
        }
        System.out.println(prefixSum[pointer - 1]);
    }
}
