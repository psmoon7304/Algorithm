package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            if(i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
                continue;
            }
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0) sb.append(arr[end]).append("\n");
            else {
                sb.append(arr[end] - arr[start - 1]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}
