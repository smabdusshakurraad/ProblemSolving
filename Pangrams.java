import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
problem list:
https://www.hackerrank.com/challenges/three-month-preparation-kit-pangrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-two
 */
public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = PangramsResult.pangrams(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
        System.out.println(result);
//        bufferedWriter.close();
    }
}
class PangramsResult{

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Write your code here
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
                "r","s","t","u","v","w","x","y","z"} ;
        String small = s.toLowerCase();
        small = small.replaceAll("\\s","");
        for(int i=0;i<alpha.length;i++){
            if(!small.contains(alpha[i])){
                return "not pangram";
            }
        }
        return "pangram";
    }
}