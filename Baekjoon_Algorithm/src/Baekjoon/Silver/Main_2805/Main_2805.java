package Baekjoon.Silver.Main_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    static int N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, map[i]);
        }

        while (left <= right) {
            long sum = 0;
            long avg = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (map[i] > avg) sum += (map[i] - avg);
            }
            if (sum < M) right = avg - 1;
            else left = avg + 1;
        }
        System.out.println(right);
    }
}
