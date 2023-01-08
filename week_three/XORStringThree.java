package week_three;

import java.util.Scanner;

/**
 * problem link:
 * https://www.hackerrank.com/challenges/three-month-preparation-kit-strings-xor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-three
 */

public class XORStringThree {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();
        String result="";
        int n = firstLine.length();
        for (int i=0;i<n;i++){
            if(firstLine.charAt(i) == secondLine.charAt(i)){
                result+="0";
            }else {
                result+="1";
            }
        }
        System.out.println(result);
    }
}
