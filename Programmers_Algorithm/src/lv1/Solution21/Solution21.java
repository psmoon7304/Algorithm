package lv1.Solution21;

public class Solution21 {
    public int solution(int number, int limit, int power) {
        int answer = 1; // 1의 약수는 1, 제한사항 1 <= number 따라서 1은 기본으로 가지고 감
        for(int i = 2; i <= number; i++) {
            int powerValue = 0;
            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) powerValue++;
            }
            powerValue += 2;
            if(powerValue > limit) answer += power;
            else answer += powerValue;
        }
        return answer;
    }
}
/* 다른사람 풀이 ( 제곱근 / 빠름 )
package lv1;

public class Solution21 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int powerValue = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) powerValue++;
                else if (i % j == 0) powerValue += 2;
            }
            if(powerValue > limit) answer += power;
            else answer += powerValue;
        }
        return answer;
    }
}
 */

/* 다른사람 풀이 ( 배수 이용 / 가장빠름 )
package lv1;

public class Solution21 {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}
 */