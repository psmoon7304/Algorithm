package d3;

import java.util.Arrays;
import java.util.Scanner;
//import java.io.FileInputStream;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] colorList = {"red", "orange", "yellow", "green", "blue", "purple"};
        for(int testCase = 1; testCase <= n; testCase++) {
            String[] color = sc.nextLine().split(" ");
            int firstColor = Arrays.asList(colorList).indexOf(color[0]);
            int secondColor = Arrays.asList(colorList).indexOf(color[1]);
            if(firstColor == secondColor) {
                System.out.println("E");
            } else if(firstColor % 3 == secondColor % 3) {
                System.out.println("C");
            } else if(firstColor + 1 == secondColor || firstColor - 1 == secondColor) {
                System.out.println("A");
            } else if(firstColor - 1 == -1) {
                if (secondColor == 5) System.out.println("A");
                else System.out.println("X");
            } else if(firstColor + 1 == 6) {
                if (secondColor == 0) System.out.println("A");
                else System.out.println("X");
            } else {
                System.out.println("X");
            }
        }
    }
}
