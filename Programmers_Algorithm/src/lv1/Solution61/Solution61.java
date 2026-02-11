package lv1.Solution61;

import java.util.Arrays;

public class Solution61 {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c - '0' >= 0 && c - '0' <= 9) {
                answer.append(c);
                continue;
            };
            temp.append(c);
            if(Arrays.asList(nums).contains(temp.toString())) {
                answer.append(Arrays.asList(nums).indexOf(temp.toString()));
                temp.setLength(0);
            };
        }
        return Integer.parseInt(answer.toString());
    }
}
