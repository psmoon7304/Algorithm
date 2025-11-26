package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_23559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, X, answer, useMoney;
    static int[][] menu;
    static int[][] info;

    private static void getResult() {
        for(int i = 0; i < N; i++) {
            if(info[i][0] == Integer.MAX_VALUE) break;
            useMoney -= 4000;
            answer -= menu[info[i][1]][0];
            answer += menu[info[i][1]][1];

            if(useMoney <= X) {
                return;
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        menu = new int[N][2];
        info = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            menu[i][0] = a;
            menu[i][1] = b;
            if(a <= b) {
                answer += menu[i][1];
                useMoney += 1000;
            } else {
                answer += menu[i][0];
                useMoney += 5000;
            }
            if(a - b <= 0) info[i] = new int[] {Integer.MAX_VALUE, i};
            else info[i] = new int[] {a - b, i};
        }
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    public static void main(String[] args) throws Exception {
        init();
        if(useMoney <= X) {
            System.out.print(answer);
            return;
        }
        getResult();
        System.out.print(answer);
    }
}
