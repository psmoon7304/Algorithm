package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B;

    private static long bfs() {
        Deque<long[]> que = new LinkedList<>();
        que.offer(new long[] {A, 1});

        while(!que.isEmpty()) {
            long[] value = que.poll();
            long multiValue = value[0] * 2;
            long addValue = value[0] * 10 + 1;
            if(multiValue == B || addValue == B) return value[1] + 1;
            if(multiValue < B) que.offer(new long[] {multiValue, value[1] + 1});
            if(addValue < B) que.offer(new long[] {addValue, value[1] + 1});
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.print(bfs());
    }
}
