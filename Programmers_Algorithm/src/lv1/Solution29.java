package lv1;

public class Solution29 {
    public int solution(int[][] sizes) {
        int max = Math.max(sizes[0][0],sizes[0][1]), min = Math.min(sizes[0][0],sizes[0][1]);
        int tempMax, tempMin;
        for(int i = 1; i < sizes.length; i++) {
            tempMax = Math.max(sizes[i][0],sizes[i][1]);
            tempMin = Math.min(sizes[i][0],sizes[i][1]);
            if(max < tempMax) max = tempMax;
            if(min < tempMin) min = tempMin;
        }
        return max * min;
    }
}
