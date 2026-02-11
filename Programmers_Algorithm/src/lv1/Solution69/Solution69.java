package lv1.Solution69;

public class Solution69 {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i : arr) answer += i;
        return answer/arr.length;
    }
}
