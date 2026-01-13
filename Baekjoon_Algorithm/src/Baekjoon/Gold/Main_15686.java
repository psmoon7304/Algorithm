package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class Main_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Deque<int[]> que;
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] housePos;
    static int[][] distance;

    private static void getStoreDis() {
        int index = 0;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            index++;
            for(int i = 0; i < housePos[0].length; i++) {
                int dis = Math.abs(housePos[i][0] - temp[0]) + Math.abs(housePos[i][1] - temp[1]);
                distance[i][index] = dis;
            }
        }
    }

    private static void combi(int d, int s, int result) {
        if(d == M) {
            answer = Math.min(answer, result);
            return;
        }

        for(int i = s; i < distance[0].length; i++) {
            for(int j = 0; j < distance.length; j++) {
                combi(d + 1, s + 1, result + distance[j][i]);
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        housePos = new int[2 * N][2];
        que = new LinkedList<>();

        int houseIndex = 0, temp;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                if(temp == 1) housePos[houseIndex++] = new int[] {i, j};
                else if(temp == 2) que.offer(new int[] {i, j});
            }
        }
        distance = new int[--houseIndex][que.size()];
    }

    public static void main(String[] args) throws Exception {
        init();
        getStoreDis();
        combi(0, 0, 0);
        System.out.println(answer);
    }

}