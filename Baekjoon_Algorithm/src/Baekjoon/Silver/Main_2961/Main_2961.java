package Baekjoon.Silver.Main_2961;

/**
 * 1. 값 입력 받기
 *  1-1. 재료 개수 입력받기
 *  1-2. 재료 개수를 가지고 재료 정보를 저장할 배열 초기화
 *  1-3. 재료 개수만큼 반복하며 신맛과 쓴맛을 입력받기 ( 배열에 저장 )
 * 2. 재료들을 가지고 '부분집합'으로 풀이
 *  2-1. 신맛은 서로 *(곱) , 쓴맛은 서로 +(합)으로 차이를 계산한다
 * 3. 만약 차이가 answer보다 작다면 이제 해당 값이 answer이 된다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2961 {
    static BufferedReader br;

    static int N;
    static int[][] dataList;
    static int answer;

    // 1. 값 입력 받기
    public static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        answer = Integer.MAX_VALUE;
        // 1-1. 재료 개수 입력받기
        N = Integer.parseInt(br.readLine().trim());
        // 1-2. 재료 개수를 가지고 재료 정보를 저장할 배열 초기화
        dataList = new int[N][2];
        // 1-3. 재료 개수만큼 반복하며 신맛과 쓴맛을 입력받기 ( 배열에 저장 )
        for(int i = 0; i < N; i++) {
            dataList[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    // 2. 재료들을 가지고 '부분집합'으로 풀이
    public static void subset(int index, int tempSour, int tempBitter) {
        if(index == N) {
            // 3. 만약 차이가 answer보다 작다면 이제 해당 값이 answer이 된다.
            if(tempSour != 1 && tempBitter != 0) answer = Math.min(answer, Math.abs(tempSour - tempBitter));
            return;
        }

        // 2-1. 신맛은 서로 *(곱) , 쓴맛은 서로 +(합)으로 차이를 계산한다
        subset(index + 1, tempSour * dataList[index][0], tempBitter + dataList[index][1]);
        subset(index + 1, tempSour, tempBitter);
    }
    public static void main(String[] args) throws Exception{
        init();
        subset(0, 1, 0);
        System.out.println(answer);
    }
}
