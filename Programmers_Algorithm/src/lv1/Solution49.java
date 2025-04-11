package lv1;

import java.util.Arrays;

public class Solution49 {
    public int solution(int[] d, int budget) {
        int cash = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            if(cash + d[i] < budget) cash += d[i];
            else if(cash + d[i] == budget) return i + 1;
            else {
                return i;
            }
        }
        return d.length;
    }
}
