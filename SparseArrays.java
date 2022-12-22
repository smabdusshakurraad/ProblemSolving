import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//problem link:
//https://www.hackerrank.com/challenges/three-month-preparation-kit-sparse-arrays/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one&h_r=next-challenge&h_v=zen
public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = SparseArraysResult.matchingStrings(strings, queries);

//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
        System.out.println(res);
//        bufferedWriter.close();
    }
}

class SparseArraysResult{
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        int[] results = new int[queries.size()];

        strings.forEach(
                s -> {
                    for(int i=0;i<queries.size();i++){
                        if(queries.get(i).equals(s)){
                            results[i]++;
                        }
                    }
                }
        );
        List<Integer> resultList = new ArrayList<>();
        for (int result : results) {
            resultList.add(result);
        }
        return resultList;
    }
}
