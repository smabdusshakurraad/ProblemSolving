import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//problem link:
// https://www.hackerrank.com/challenges/three-month-preparation-kit-grading/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-two&h_r=next-challenge&h_v=zen

public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LonelyIntegerResult.lonelyinteger(a);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
        System.out.println(result);
//        bufferedWriter.close();
    }
}
class LonelyIntegerResult{
    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> duplicateMap = new HashMap<>();
        int lonely = 0;
        for (Integer integer : a) {
            if (duplicateMap.containsKey(integer)) {
                duplicateMap.put(integer, duplicateMap.get(integer) + 1);
            } else {
                duplicateMap.put(integer, 1);
            }
        }
        if (duplicateMap.containsValue(1)) {
            for (int i = 0; i < a.size(); i++) {
                if (duplicateMap.get(a.get(i)) == 1) {
                    lonely = a.get(i);
                }
            }
        }

        return lonely;
    }
}