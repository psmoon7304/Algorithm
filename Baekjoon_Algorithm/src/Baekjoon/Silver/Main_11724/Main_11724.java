package Baekjoon.Silver.Main_11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_11724 {
    static int N, M;
    // info 배열은 이제 필요 없으므로 삭제하거나 주석 처리합니다.
    // static int[][] info;
    static HashMap<Integer, Set<Integer>> network = new HashMap<>();

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 간선을 하나씩 읽으면서 바로 처리합니다.
        for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // u와 v가 각각 어느 그룹에 속해있는지 찾기 위한 변수
        Integer keyForU = null;
        Integer keyForV = null;

        // 전체 그룹을 탐색하며 u와 v가 속한 그룹의 대표 키(key)를 찾습니다.
        for (Map.Entry<Integer, Set<Integer>> entry : network.entrySet()) {
            int currentKey = entry.getKey();
            Set<Integer> currentSet = entry.getValue();

            // u가 현재 그룹에 속해있는지 확인 (대표 노드이거나, 그룹 멤버이거나)
            if (currentKey == u || currentSet.contains(u)) {
                keyForU = currentKey;
            }
            // v가 현재 그룹에 속해있는지 확인
            if (currentKey == v || currentSet.contains(v)) {
                keyForV = currentKey;
            }
        }

        // --- 찾은 결과를 바탕으로 경우를 나누어 처리 ---

        if (keyForU != null && keyForV != null) {
            // Case 1: u와 v가 모두 기존 그룹에 속해 있을 때
            if (!keyForU.equals(keyForV)) { // 그리고 그 그룹이 서로 다를 때
                // *** 핵심 수정: 두 그룹을 하나로 합칩니다 (MERGE) ***
                Set<Integer> setU = network.get(keyForU);
                Set<Integer> setV = network.get(keyForV);

                // v그룹의 모든 멤버와, v그룹의 대표 노드(keyForV)까지 u그룹으로 옮김
                setU.addAll(setV);
                setU.add(keyForV);

                // v그룹은 이제 u그룹에 합쳐졌으므로 삭제
                network.remove(keyForV);
            }
            // 만약 keyForU.equals(keyForV)이면 이미 같은 그룹이므로 아무것도 안 함.

        } else if (keyForU != null) {
            // Case 2: u만 기존 그룹에 속해 있을 때 -> v를 u의 그룹에 추가
            network.get(keyForU).add(v);

        } else if (keyForV != null) {
            // Case 3: v만 기존 그룹에 속해 있을 때 -> u를 v의 그룹에 추가
            network.get(keyForV).add(u);

        } else {
            // Case 4: u와 v 모두 새로운 노드일 때 -> 새로운 그룹 생성
            network.put(u, new HashSet<>());
            network.get(u).add(v);
        }
    }

    // --- 고립된 노드 계산 ---
    boolean[] isConnected = new boolean[N + 1];
    int connectedNodeCount = 0;

    // 그룹에 속한 노드들을 모두 true로 체크
        for (Map.Entry<Integer, Set<Integer>> entry : network.entrySet()) {
        if (!isConnected[entry.getKey()]) {
            isConnected[entry.getKey()] = true;
            connectedNodeCount++;
        }
        for (int node : entry.getValue()) {
            if (!isConnected[node]) {
                isConnected[node] = true;
                connectedNodeCount++;
            }
        }
    }

    // (전체 노드 수 - 연결된 노드 수) = 고립된 노드 수
    int isolatedNodeCount = N - connectedNodeCount;

    // 최종 결과: (연결된 그룹의 수) + (고립된 노드의 수)
        System.out.println(network.size() + isolatedNodeCount);
}
}
