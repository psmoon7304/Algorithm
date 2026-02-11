package Baekjoon.Gold.Main_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, L;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[] snakeAction = new char[10001];
    static Deque<int[]> snakeBody = new LinkedList<>();

    private static int startGame() {
        int time = 0, pointer = 0;
        while(true) {
            time++;
            int[] head = snakeBody.peek();
            int r = head[0] + dr[pointer];
            int c = head[1] + dc[pointer];
            if(!checked(r, c) || map[r][c] == -1) return time;

            if(map[r][c] != 1) {
                int[] tail = snakeBody.pollLast();
                map[tail[0]][tail[1]] = 0;
            }
            map[r][c] = -1;
            snakeBody.offerFirst(new int[] {r, c});
            if(snakeAction[time] != '\0') {
                if(snakeAction[time] == 'L') {
                    if(pointer == 0) pointer = 3;
                    else pointer--;
                }
                else {
                    if (pointer == 3) pointer = 0;
                    else pointer++;
                }
            }
        }
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        K = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        L = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine().trim());
            snakeAction[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }
        snakeBody.offer(new int[] {0, 0});
        map[0][0] = -1;
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(startGame());
    }
}
