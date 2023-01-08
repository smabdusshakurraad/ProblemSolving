package week_three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SalesByMatchResult.sockMerchant(n, ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println(result);

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
class SalesByMatchResult{
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int[] count = new int[100];
        int pairs = 0;
        for(int i =0;i<n;i++){
            count[ar.get(i)-1]++;
        }
        for(int i=0;i<100;i++){
            if(count[i]!=0){
                pairs+= count[i]/2;
            }
        }
        return pairs;
    }
}
