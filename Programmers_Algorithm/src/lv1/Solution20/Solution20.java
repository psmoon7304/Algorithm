package lv1.Solution20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution20 {
    private int setTarget(String data) {
        if(data.equals("code")) return 0;
        else if(data.equals("date")) return 1;
        else if(data.equals("maximum")) return 2;
        else return 3;
    }
    private int[][] sort(List<List<Integer>> value, int target) {
        int row = value.size();
        int col = value.get(0).size();
        int[][] answer = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                answer[i][j] = value.get(i).get(j);
            }
        }
        for(int i = 0; i < row - 1; i++) {
            for(int j = i + 1; j < row; j++) {
                if(answer[i][target] > answer[j][target]) {
                    int[] tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
            }
        }
        return answer;
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<List<Integer>> answer = new ArrayList<>();
        int target = setTarget(ext);

        for(int i = 0; i < data.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            if(data[i][target] < val_ext) {
                for(int j = 0; j < data[i].length; j++) {
                    tempList.add(data[i][j]);
                }
                answer.add(tempList);
            }
        }
        target = setTarget(sort_by);;
        return sort(answer, target);
    }
}
