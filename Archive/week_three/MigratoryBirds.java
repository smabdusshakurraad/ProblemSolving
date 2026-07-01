package week_three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * problem link:
 * https://www.hackerrank.com/challenges/three-month-preparation-kit-migratory-birds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-three&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = MigratoryBirdsResult.migratoryBirds(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println(result);
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
class MigratoryBirdsResult{
    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] count = new  int[5];
        int lowestType=0;

        for(int i=0;i<arr.size();i++){
            count[arr.get(i)-1]++;
        }
        for(int i=0;i<5;i++){
            for (int j=i+1;j<5;j++){
                if(count[j]>count[lowestType] && j>lowestType) {
                    lowestType = j;
                }
            }
        }
        return lowestType+1;
    }
}