package Baekjoon.Gold.Main_20926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int e, w;
    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main_20926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static char[] map;
    static int[] player;

    static int[] dijkMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int W, H;

    private static int dijk() {
        int startPos = convertToIndex(player[0], player[1]);
        dijkMap[startPos] = 0;
        pq.offer(new Node(startPos, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(dijkMap[now.e] < now.w) continue;
            if(map[now.e] == 'E') return now.w;
            int[] nowPos = convertToPos(now.e);

            for(int i = 0; i < 4; i++) {
                int r = nowPos[0];
                int c = nowPos[1];
                int sumW = 0;
                int check = 0;
                while(true) {
                    r += dr[i];
                    c += dc[i];
                    int index = convertToIndex(r, c);
                    if(!checked(r, c) || map[index] == 'H') break;
                    else if(map[index] == 'E') {
                        check = 1;
                        break;
                    } else if(map[index] == 'R') {
                        r -= dr[i];
                        c -= dc[i];
                        check = 1;
                        break;
                    }
                    sumW += map[index] - '0';
                }
                if(check == 1) {
                    int index = convertToIndex(r, c);
                    if(dijkMap[index] <= now.w + sumW) continue;
                    dijkMap[index] = now.w + sumW;
                    pq.offer(new Node(index, now.w + sumW));
                }
            }


        }
        return -1;
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    private static int convertToIndex(int r, int c) {
        return r * W + c;
    }

    private static int[] convertToPos(int index) {
        return new int[] {index / W, index % W};
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[W * H];


        dijkMap = new int[W * H];

        for(int i = 0; i < H; i++) {
            char[] mapValue = br.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                if(mapValue[j] == 'T') player = new int[] {i, j};
                dijkMap[i * W + j] = Integer.MAX_VALUE;
                map[i * W + j] = mapValue[j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(dijk());
    }
}