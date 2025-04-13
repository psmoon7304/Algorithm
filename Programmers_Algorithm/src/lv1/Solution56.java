package lv1;

public class Solution56 {
    public long solution(long n) {
        if(Math.sqrt(n) % 1 == 0) return (long)Math.pow(Math.sqrt(n) + 1, 2);
        return -1;
    }
}
