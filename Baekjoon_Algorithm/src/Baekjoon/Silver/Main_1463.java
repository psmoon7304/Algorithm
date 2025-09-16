package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] numArray;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        numArray = new int[N + 1];
        for(int i = 2; i <= N; i++) {
            numArray[i] = numArray[i - 1] + 1;
            if(i % 3 == 0) {
                numArray[i] = Math.min(numArray[i], numArray[i / 3] + 1);
            }
            if(i % 2 == 0) {
                numArray[i] = Math.min(numArray[i], numArray[i / 2] + 1);
            }
        }
        System.out.println(numArray[N]);
    }
}
