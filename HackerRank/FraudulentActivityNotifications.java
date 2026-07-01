import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int notificationCount = 0;
        int[] counts = new int[201];

        for(int i=0; i<d; i++){
            counts[expenditure.get(i)]++;
        }

        for(int i = d; i<expenditure.size(); i++){

            double median = getMedian(counts, d);
            if(expenditure.get(i) >= 2 * median){
                notificationCount++;
            }

            counts[expenditure.get(i-d)]--;
            counts[expenditure.get(i)]++;
        }

        return notificationCount;
    }

    public static double getMedian(int[] counts, int d){
        int count = 0;
        Integer first = null;
        Integer second = null;

        if(d % 2 != 0){
            for(int i = 0; i<counts.length; i++){
                count+= counts[i];

                if(count > d/2){
                    return i;
                }
            }
        }
        else{
            for(int i =0; i<counts.length; i++){
                count+= counts[i];
                if(first == null && count >= d/2){
                    first = i;
                }
                if(second == null && count >= (d/2)+1){
                    second = i;
                    return (first + second) / 2.0;
                }
            }
        }
        return 0.0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
