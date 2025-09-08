package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] sugarList;
    static int N;
    static final int MAX_VALUE = 9999;

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        sugarList = new int[N + 3]; // N은 3 이상의 값이 들어오는데 아래 코드에서 5번째 값을 1로 바꿔주는 코드가 있기 때문에 에러를 방지차 + 3을 해줌
        Arrays.fill(sugarList,MAX_VALUE);
        sugarList[3] = 1;
        sugarList[5] = 1;
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 6; i <= N; i++) {
            int tempValue = Math.min(sugarList[i - 3], sugarList[i - 5]);

            sugarList[i] = (tempValue == 9999 ? 9999 : tempValue + 1);
        }
        System.out.println(sugarList[N] == 9999 ? -1 : sugarList[N]);
    }
}
