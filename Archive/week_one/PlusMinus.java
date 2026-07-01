package week_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int pos=0,neg=0,zeros=0;
        int n = arr.size();
        int[] arrs = new int[n];
        for(int i=0; i<n;i++){
            arrs[i] = arr.get(i);
        }
        // Write your code here
        for (int i=0;i<n;i++) {
            if (arrs[i] > 0) {
                pos++;
            } else if (arrs[i] < 0) {
                neg++;
            }else{
                zeros++;
            }
        }
        System.out.printf("%.6f%n",(double)pos/(double)n);
        System.out.printf("%.6f\n",(double)neg/(double)n);
        System.out.printf("%.6f\n",(double)zeros/(double)n);
    }

}
