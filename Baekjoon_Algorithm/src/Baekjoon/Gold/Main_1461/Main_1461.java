package Baekjoon.Gold.Main_1461;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, zeroPointer, answer;
    static int[] dataArray;

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dataArray = new int[N + 1];
        int pointer = 0, breakPoint = 0;
        st = new StringTokenizer(br.readLine().trim());

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp > 0 && breakPoint == 0) {
                zeroPointer = pointer;
                dataArray[pointer++] = 0;
                breakPoint = 1;
            }
            dataArray[pointer++] = temp;
        }
        Arrays.sort(dataArray);
    }

    public static void main(String[] args) throws Exception {
        init();
        //if(N < M)
    }
}
