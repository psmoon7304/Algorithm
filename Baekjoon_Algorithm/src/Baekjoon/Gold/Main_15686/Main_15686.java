package Baekjoon.Gold.Main_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, answer = Integer.MAX_VALUE, storeSize, houseSize;
    static int[][] housePos;
    static int[][] storePos;
    static int[] pickStore;

    private static int getStoreDis() {
        int sum = 0;
        for(int i = 0; i < houseSize; i++) {
            int temp = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++) {
                temp = Math.min(Math.abs(housePos[i][0] - storePos[pickStore[j]][0]) + Math.abs(housePos[i][1] - storePos[pickStore[j]][1]), temp);
            }
            sum += temp;
        }
        return sum;
    }

    private static void combi(int d, int s) {
        if(d == M) {
            answer = Math.min(answer, getStoreDis());
            return;
        }

        for(int i = s; i < storeSize; i++) {
            pickStore[d] = i;
            combi(d + 1, i + 1);
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        housePos = new int[2 * N][2];
        storePos = new int[13][2];
        pickStore = new int[M];

        int temp;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                if(temp == 1) housePos[houseSize++] = new int[] {i, j};
                else if(temp == 2) {
                    storePos[storeSize++] = new int[] {i, j};
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        combi(0, 0);
        System.out.println(answer);
    }

}

/*
    M개를 제외한 나머지는 폐업
    M개를 먼저 선발 후 해당 치킨집을 가지고 거리 계산 후 해당 거리가 가장 짧은 애가 정답
    집 위치를 저장 housePos
    가게 위치를 저장 storePos

    combie 조합으로 먼저 경우의 수를 뽑고 해당 경우의 수로 정답을 구함
 */