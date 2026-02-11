package lv1.Solution34;
import java.util.Arrays;
public class Solution34 {
    public int solution(int[] mats, String[][] park) {
        int check = 0;
        int answer = -1;
        Arrays.sort(mats);
        for(int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                if(park[i][j].equals("-1")) {
                    for(int matsSize : mats) {
                        check = 0;
                        for(int k = 0; k < matsSize; k++) {
                            for(int l = 0; l < matsSize; l++) {
                                if(i + k >= park.length || j + l >= park[i].length || !(park[i+k][j+l].equals("-1"))) {
                                    check = -1;
                                    break;
                                }
                            }
                            if(check == -1) break;
                        }
                        if(check == 0) {
                            if(answer < matsSize) {
                                answer = matsSize;
                            }
                            break;
                        }
                    }
                }

            }
        }
        return answer;
    }
}

/* 두 코드다 본인이 작성
package lv1;

public class Solution34 {
    public int solution(int[] mats, String[][] park) {
        int check = 0;
        int answer = -1;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                if(park[i][j].equals("-1")) {
                    for(int matsSize : mats) {
                        check = 0;
                        for(int k = 0; k < matsSize; k++) {
                            for(int l = 0; l < matsSize; l++) {
                                if(i + k >= park.length || j + l >= park[i].length || !(park[i+k][j+l].equals("-1"))) {
                                    check = -1;
                                    break;
                                }
                            }
                            if(check == -1) break;
                        }
                        if(check == 0 && answer < matsSize) {
                            answer = matsSize;
                        };
                    }
                }

            }
        }
        return answer;
    }
}
 */