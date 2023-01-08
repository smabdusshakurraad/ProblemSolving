package week_one;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Solution.miniMaxSum(arr);

        bufferedReader.close();
    }
}

class Solution {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        long max =0,min=0;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = arr.get(i);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(array[j]<array[i]){
                    array[i] += array[j];
                    array[j] = array[i] - array[j];
                    array[i] -= array[j];
//                    int temp;
//                    temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
                }
            }
        }
        for(int i=0;i<4;i++){
            min += array[i];
            max += array[n-i-1];
        }


        System.out.println(min+" "+max);
    }

}