package lv1;

import java.util.Arrays;

public class Solution73 {
    public long solution(long n) {
        StringBuilder answer = new StringBuilder();
        char[] s = String.valueOf(n).toCharArray();
        Arrays.sort(s);
        for(int i = s.length - 1; i >= 0; i--) answer.append(s[i]);
        return Long.parseLong(answer.toString());
    }
}
