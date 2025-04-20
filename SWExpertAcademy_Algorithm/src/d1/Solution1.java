package d1;

import java.util.Scanner;
//import java.io.FileInputStream;

public class Solution1 {
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        int answer;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] num = sc.nextLine().split(" ");
            answer = 0;
            for(int i = 0; i < num.length; i++) if(Integer.parseInt(num[i]) % 2 != 0) answer += Integer.parseInt(num[i]);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
