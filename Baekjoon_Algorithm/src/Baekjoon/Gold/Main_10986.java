package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static long[] prefix;
    static long[] counts;

    private static long getResult() {
        long answer = 0;
        int remainder = 0;
        for(int i = 1; i <= N; i++) {
            remainder = (int)(prefix[i] % M);
            if(remainder == 0) answer++;
            answer += counts[remainder];
            counts[remainder]++;
        }
        return answer;
    }

    private static void prefixSum() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefix = new long[N + 1];
        counts = new long[M];
    }

    public static void main(String[] args) throws Exception {
        init();
        prefixSum();
        System.out.println(getResult());
    }

}
