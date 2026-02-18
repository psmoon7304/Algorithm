package Baekjoon.Gold.Main_20926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int e, w;
    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main_20926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int W, H;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0 ,-1};
    static int[][] map; //T : -1, R : -2, H : Integer.MAX_VALUE, E : -99
    static int player, escape;

    private static int createMap(char tempChar, int i, int j) {
        int value = tempChar - '0';
        if(tempChar == 'T') {
            player = i * W + j;
            value = -1;
        } else if(tempChar == 'E') {
            escape = i * W + j;
            value = -99;
        } else if(tempChar == 'R') {
            value = -2;
        } else if(tempChar == 'H') {
            value = Integer.MAX_VALUE;
        }
        return value;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i = 0; i < H; i++) {
            char[] mapInfo = br.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                char tempChar = mapInfo[j];
                map[i][j] = createMap(tempChar, i, j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
    }
}

/*
    미끌어지며 이동하는 경우, 돌이 없으면 멈추지 못해서 맵 밖으로 나가게 됨 < 이거 중요 >
    출구로 들어가는 경우, 출구의 미끌 시간은 포함 x
    한쪽 방향으로 이동을 시작하면 시작 빙판의 미끌 시간은 포함 x

    그렇다면 delta 서치를 통해서 해당 방향에 돌이 있는지 확인, 없다면 못감

    그럼 입력받을 때 돌들의 위치를 별도로 저장
    E, R 위치들 다 저장
    출발할때 가려는 방향에 E나 R이 없다면 못감
    있다면 갈 방향의 가중치들을 다 계산, PQ사용
 */
