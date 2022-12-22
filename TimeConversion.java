import java.io.*;

/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
class TimeConversionResult{
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String hour = s.substring(0,2);
        String period = s.substring(s.length()-2);
        String timeWithoutPeriod = s.substring(0,s.length()-2);
        String timeWithoutHourAndPeriod = s.substring(2,s.length()-2);
        String newTime;
        if(period.equals("AM")){
            if(hour.equals("12")){
                newTime="00"+ timeWithoutHourAndPeriod;
            }else {
                newTime = timeWithoutPeriod;
            }
        }else{
            if(hour.equals("12")){
                newTime = timeWithoutPeriod;
            }else{
                int newHour = 12+Integer.parseInt(hour);
                newTime = newHour+timeWithoutHourAndPeriod;
            }
        }
        System.out.println(newTime);
        return newTime;
    }
}
