package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9017 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, ArrayList<Integer>> team = new HashMap<>();

    static int T, N;
    static int[] rank, player;

    private static int getWinner() {
        int[] answer = new int[3];

        for(Map.Entry<Integer, ArrayList<Integer>> entry : team.entrySet()) {
            int tempScore = Integer.MAX_VALUE;
            for(int i = 0; i < 5; i++) {
                if(i != 4) {
                    tempScore += entry.getValue().get(i);
                    continue;
                }
                if(answer[1] > tempScore) {
                    answer[0] = entry.getKey();
                    answer[1] = tempScore;
                    answer[2] = entry.getValue().get(i);
                } else if(answer[1] == tempScore) {
                    if(answer[2] > entry.getValue().get(i)) {
                        answer[0] = entry.getKey();
                        answer[1] = tempScore;
                        answer[2] = entry.getValue().get(i);
                    }
                }
            }
        }
        return answer[0];
    }

    private static void init() throws Exception {
        int point = 1;
        team.clear();
        N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        rank = new int[N];
        player = new int[N];

        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            player[i - 1] = value;
            rank[value]++;
        }

        for(int i = 1; i <= N; i++) {
            int value = player[i - 1];
            if(rank[value] < 6) continue;
            if(!team.containsKey(value)) team.put(value, new ArrayList<>());
            team.get(value).add(point);
            point += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < T; i++) {
            init();
            sb.append(getWinner()).append("\n");
        }
        System.out.println(sb.toString());
    }
}