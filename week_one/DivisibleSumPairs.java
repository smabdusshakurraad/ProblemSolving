package week_one;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DivisibleSumPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = DivisibleSumPairsResult.divisibleSumPairs(n, k, ar);

       // bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();
        bufferedReader.close();
        System.out.println(result);
      //  bufferedWriter.close();
    }
}

class DivisibleSumPairsResult{

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int pairs = 0;
        // Write your code here
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = ar.get(i);
        }

        for(int i=0; i<n;i++){
            for (int j=i+1;j<n;j++){
                if((arr[i]+arr[j])%k == 0){
                    pairs++;
                }
            }
        }
        return pairs;
    }
}

