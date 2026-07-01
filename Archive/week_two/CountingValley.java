package week_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-two
 */
public class CountingValley {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleyResult.countingValleys(steps, path);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
        System.out.println(result);
//        bufferedWriter.close();
    }
}

class CountingValleyResult{
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int seaLevel = 0;
        int valley =0;
        for(int i =0;i<steps;i++){
            if(path.charAt(i) == 'U'){
                seaLevel++;
            } else if (path.charAt(i) == 'D') {
                if(seaLevel == 0){
                    valley++;
                }
                seaLevel--;
            }
        }
        return valley;
    }
}
