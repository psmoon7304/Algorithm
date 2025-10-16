package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, answer = Integer.MIN_VALUE;
    static int[] arr;

    private static void getMaxValue() {
        for(int i = M; i <= N; i++) {
            answer = Math.max(arr[i] - arr[i - M], answer);
        }
    }

    private static void prefixSum() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
    }

    public static void main(String[] args) throws Exception {
        init();
        prefixSum();
        getMaxValue();
        System.out.println(answer);
    }
}
