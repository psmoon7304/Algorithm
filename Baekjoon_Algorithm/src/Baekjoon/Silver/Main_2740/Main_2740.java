package Baekjoon.Silver.Main_2740;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2740 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[][] A, B;

    private static void getResult() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int temp = 0;
                for(int k = 0; k < M; k++) {
                    temp += A[i][k] * B[k][j];
                }
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        B = new int[M][K];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        getResult();
        System.out.print(sb.toString());
    }
}
