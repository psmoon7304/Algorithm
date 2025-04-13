package lv1;

public class Solution54 {
    public boolean solution(int x) {
        int temp = 0;
        String num = String.valueOf(x);
        for(int i = 0; i < num.length(); i++) temp += num.charAt(i) - '0';
        if(x % temp == 0) return true;
        return false;
    }
}
