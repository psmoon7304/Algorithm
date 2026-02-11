package Baekjoon.Silver.Main_1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1913 {
    static int N;
    static int target;
    static int[] pointer;
    static int[][] map;
    static int[] answer = new int[2];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        map = new int[N][N];
        pointer = new int[] {N/2, N/2};

        int count = 0, temp = 0, max = 1, move = 0;
        for(int i = 1; i <= N * N; i++) {
            map[pointer[0]][pointer[1]] = i;
            pointer[0] += dr[temp % 4];
            pointer[1] += dc[temp % 4];
            count++;
            if(count == max) {
                count = 0;
                move++;
                temp++;
            }
            if(move == 2) {
                max++;
                move = 0;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
                if(map[i][j] == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                }
            }
            sb.append("\n");
        };
        sb.append(answer[0] + " " + answer[1]);
        System.out.println(sb.toString());

    }
}