import java.util.Scanner;
/*
problem link:
https://www.hackerrank.com/challenges/three-month-preparation-kit-camel-case/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
public class CamelCaseFour {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String line, text;
        StringBuilder word;
        char operation,type;
        String[] words = null;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            operation =  line.charAt(0);
            type = line.charAt(2);
            word = new StringBuilder();
            if(operation == 'S'){
                if(type == 'M'){
                    text = line.substring(4,line.length()-2);
                }else {
                    text = line.substring(4);
                }
                for(int i=0; i<text.length();i++){
                    if(Character.isUpperCase(text.charAt(i))){
                        if(i>0){
                            word.append(" ");
                        }
                        word.append(Character.toLowerCase(text.charAt(i)));
                    } else if (Character.isLetter(text.charAt(i))) {
                        word.append(text.charAt(i));
                    }
                }
                System.out.println(word);
            } else if (operation == 'C') {
                text = line.substring(4);
                words = text.split(" ");
                if(type == 'C'){
                    words[0] = words[0].substring(0,1).toUpperCase() + words[0].substring(1).toLowerCase();
                }
                System.out.print(words[0]);
                for (int i=1;i<words.length;i++){
                    words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
                    System.out.print(words[i]);
                }
                if(type == 'M'){
                    System.out.print("()");
                }
                System.out.print("\n");
            }
        }
    }
}
