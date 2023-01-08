import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-mars-exploration/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-two
 */
public class MarsExploration {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = MarsExplorationResult.marsExploration(s);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
        System.out.println(result);
//        bufferedWriter.close();
    }
}
class MarsExplorationResult{
    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int changed = 0;
        // Write your code here
        for(int i=0;i<s.length();i+=3){
            if(s.charAt(i) != 'S'){
                changed++;
            }
            if(s.charAt(i+1) != 'O'){
                changed++;
            }
            if(s.charAt(i+2) != 'S'){
                changed++;
            }
        }
        return changed;
    }
}
