package lv1;

public class Solution25 {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] day = {"THU", "FRI","SAT","SUN","MON","TUE","WED"};
        int temp = 0;

        for(int i = 0; i < a - 1; i++) temp += month[i];
        temp += b;
        return day[temp % 7];
    }
}
