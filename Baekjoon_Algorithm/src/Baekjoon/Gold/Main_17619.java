package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_17619 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static long[][] wood;
    static long[] woodIndex;

    private static void linkedWood() {
        long end = wood[0][1], index = 0;
        woodIndex[Long.valueOf(wood[0][3]).intValue()] = index;
        for(int i = 1; i < N; i++) {
            if(wood[i][0] <= end) {
                end = Math.max(wood[i][1], end);
            } else {
                index++;
                end = wood[i][1];
            }
            woodIndex[Long.valueOf(wood[i][3]).intValue()] = index;
        }
    }

    private static void sortWood() {
        Arrays.sort(wood, new Comparator<long[]>(){
           @Override
           public int compare(long[] o1, long[] o2) {
               return Long.valueOf(o1[0] - o2[0]).intValue();
           }
        });
    }

    private static int tryJump(long s, long e) {
        return woodIndex[Long.valueOf(s).intValue()] == woodIndex[Long.valueOf(e).intValue()] ? 1 : 0;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        wood = new long[N][4];
        woodIndex = new long[N];

        long x1, x2, y;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            wood[i] = new long[] {x1, x2, y, i};
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        sortWood();
        linkedWood();
        long start, end;
        for(int i = 0; i < Q; i ++) {
            st = new StringTokenizer(br.readLine().trim());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(tryJump(start, end)).append("\n");
        }
        System.out.print(sb.toString());
    }
}

/*
초기 생각
- 그리디 문제로 생각
- 1. 확인을 해야하는 것
    - 지나쳐온 통나무를 다시 지나쳐서 가도되는지 아니면 한 번에 이동을 해야하는 것인지
        - ex ) 1 - 2 - 3 이것만 가능한지 아니면 1 - 2 - 3 - 2 - 4
- 2. 고려해야 할 것
    - 한 번에 두개의 통나무를 건널 수 없음. -> 이 말을 보면 앞서 확인해야 하는 내용이 불가능 할 것으로 보임.
        - 하지만 문제에서 '한번 이상의 점프' 라는 말을 보았을 때는 또 확인해야 하는 내용이 가능해 보임.
- 3. 방법
    - 3-1 방법 1 ( 통나무 중복으로 밟아도 상관 x )
        - 3-1-1. 정렬전 좌표들을 별도로 저장 후, 통나무의 x1 좌표를 기준으로 정렬
        - 3-1-2. 정렬된 좌표를 가지고 이어지는 구간을 생성
        - 3-1-3. 건너려는 통나무의 번호를 별도로 저장해둔 배열에 인덱스로 접근하여 시작지점의 x1 좌표와,
                 종료지점의 x1 좌표를 가져와서 이어지는 구간안에 해당되는지 확인
        - 3-1-4. 해당된다면 1, 불가능하다면 0

        -> 결과 19점

        -> 왜 그럴까 개인적인 분석 : 점프를 뛰는 경우 모든 구간들을 비교하기 때문에 메모리 혹은 시간이 터짐, 그리고 int 사용
        -> 해결법 : 현재 통나무에 해당되는 구간을 즉시 확인하는 방식으로 변경이 필요함 , long으로 타입 변환
        -> 비고 : 우선 현재 제출을 해보니 중복으로 밟아도 상관 없어보임.

        -> 최종 : 구간을 기록 함수속 if에서 값을 ~~보다 큰 경우도 확인을 하였었는데 생각해보니 정렬이 되어 있어서 하지 않아도 됨.
        정렬전 통나무의 인덱스를 기록하도록 수정하여 같은 구간인지를 확인할 수 있도록 수정
        그렇다 보니 굳이 구간을 별도로 저장할 필요가 없어져 ArrayList 삭제
 */