package Baekjoon.Silver.Main_15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] numbers;

    static void combi(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) sb.append(numbers[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            numbers[cnt] = i;
            combi(cnt + 1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        combi(0, 1);
        System.out.print(sb.toString());
    }

}
