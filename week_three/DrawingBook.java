package week_three;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = DrawingBookResult.pageCount(n, p);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
class DrawingBookResult{
    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        int count =0;
        // Write your code here
        if(p+1 == n || p-1 == 1){
            return count;
        }
        if(n-p<p-1){
            while(n > p){
                n -= 2;
                count++;
            }
        }else {
            while (p>1){
                p -=2;
                count++;
            }
        }
        return count;
    }

}