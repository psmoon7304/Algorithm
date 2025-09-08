package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, answer = 0;
    static int[] map;

    static void setQueen(int r) {
        if(r == N) {
            answer++;
            return;
        }

        for(int i = 0; i < N; i++) {
            map[r] = i;
            if(check(r)) {
                setQueen(r + 1);
            }
        }
    }

    static boolean check(int r) {
        for(int i = 0; i < r; i++) {
            if(map[r] == map[i]) return false;
            else if(Math.abs(r - i) == Math.abs(map[r] - map[i])) return false;
        }
        return true;
    }

    static public void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N];
        setQueen(0);
        System.out.print(answer);
    }
}
