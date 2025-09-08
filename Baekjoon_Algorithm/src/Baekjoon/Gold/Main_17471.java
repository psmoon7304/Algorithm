package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main_17471 {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, citizenCount = 0, minimum = Integer.MAX_VALUE;
    static int[] citizenList; // 지역 별 인구수
    static ArrayList[] areaList; // 각 구역 별 인접 지역 리스트
    static BitSet visited; // 방문여부

    // BFS

    // 초기 셋팅 ( 값 입력 및 초기화 )
    static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        citizenList = new int[N + 1]; // 0은 사용하지 않음
        areaList = new ArrayList[N + 1]; // 0은 사용하지 않음
        for(int i = 0; i <= N; i++) areaList[i] = new ArrayList<>();

        // 지역 별 인구수 값 입력
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++)  {
            citizenList[i] = Integer.parseInt(st.nextToken());
            citizenCount += citizenList[i]; // 모든 지역 인구수의 합 ( 추후 두 구역으로 나눌 때 전체 인구수 - 선택 인구수로 최소 값 구함
        }

        // 각 구역 별 인접 지역 리스트 ( i 지역은 ArrayList.get 지역과 인접 )
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int loopCount = Integer.parseInt(st.nextToken()); // i 지역의 인접 지역 개수
            for(int j = 0; j < loopCount; j++) {
                int tempValue = Integer.parseInt(st.nextToken());
                if(areaList[i].contains(tempValue)) continue; // 중복 값 방지
                areaList[i].add(tempValue);
                areaList[tempValue].add(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        init();

        if(minimum == Integer.MAX_VALUE) minimum = -1; // 두 선거구로 분리 불가시 -1 리턴
        System.out.println(minimum);
    }
}
