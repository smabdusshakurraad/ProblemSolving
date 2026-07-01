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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        int[] charCounts = new int[26];
        for(char c : s.toCharArray()){
            charCounts[c-'a']++;
        }

        HashMap<Integer, Integer> frequeMap = new HashMap<>();
        for(int count : charCounts){
            if(count>0){
                frequeMap.put(count, frequeMap.getOrDefault(count, 0)+1);
            }
        }

        if(frequeMap.size() == 1){
            return "YES";
        }

        if(frequeMap.size() > 2){
            return "NO";
        }

        int[] freqs = new int[2];
        int[] counts = new int[2];
        int index = 0;

        for(Map.Entry<Integer, Integer> entry : frequeMap.entrySet()){
            freqs[index] = entry.getKey();
            counts[index] = entry.getValue();
            index++;
        }

        if((freqs[0] == 1 && counts[0] == 1) || (freqs[1] == 1 && counts[1] ==1) ){
            return "YES";
        }

        if((freqs[0] - freqs[1] == 1 && counts[0] == 1) || (freqs[1] - freqs[0] == 1 && counts[1] == 1)){
            return "YES";
        }

        return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
