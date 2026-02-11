package Baekjoon.Gold.Main_1806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S, answer = Integer.MAX_VALUE;
    static int[] arr;

    private static int getAnswer() {
        if(arr[N] < S) return 0;

        int start = 1, end = 1;
        while(true) {
            int sum = arr[end] - arr[start - 1];
            if(sum >= S) {
                answer = Math.min(answer, end - start + 1);
                start++;
            } else {
                end++;
            }
            if(start > end) end = start;
            if(end > N) break;
        }
        return answer;
    }

    private static void prefixSum() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value >= S) {
                answer = 1;
                return;
            }
            arr[i] = arr[i - 1] + value;
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        S  = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
    }

    public static void main(String[] args) throws Exception {
        init();
        prefixSum();
        if(answer == 1) System.out.println(answer);
        else System.out.println(getAnswer());
    }
}
