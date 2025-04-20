package lv1;

public class Solution76 {
    private String binarry(int n, int count) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < count; i++) {
            if(n == 0) result.insert(0, " ");
            else if(n % 2 == 0) result.insert(0, " ");
            else result.insert(0, "#");
            n /= 2;
        }
        return result.toString();
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] temp = new String[n][2];
        for(int i = 0; i < n; i++) {
            temp[i][0] = binarry(arr1[i],n);
            temp[i][1] = binarry(arr2[i],n);
        }
        for(int i = 0; i < n; i++) {
            StringBuilder tempString = new StringBuilder();
            for(int j = 0; j < n; j++) {
                char[] array1 = temp[i][0].toCharArray();
                char[] array2 = temp[i][1].toCharArray();
                if(array1[j] == array2[j]) tempString.append(array1[j]);
                else tempString.append("#");
            }
            answer[i] = tempString.toString();
        }
        return answer;
    }
}
