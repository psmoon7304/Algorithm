package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
    static int N, r, c;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[1<<N][1<<N];
        div(0,0,(1<<N), 0);
    }

    public static void div(int i, int j, int size, int num) {
        if(i == r && j == c) {
            System.out.println(num);
            return;
        }
        if(r >= i && r < i + size && c >= j && c < j + size) {
            size /= 2;
            div(i, j, size, num);
            div(i, j + size, size, num + (size*size));
            div(i + size, j, size, num + (size*size) * 2);
            div(i + size, j + size, size, num + (size*size) * 3);
        }
    }
}
