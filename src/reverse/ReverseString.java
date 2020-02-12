package reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1. use new char array and iterate and insert
    2. convert string to char array, use reverse Array logic
    3. use charAt method of String, iterate in reverse , append to string builder.

    Time Complexity: ?? calculate
*/
public class ReverseString {
    public static void main(String []args) {

        System.out.println("enter input");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }


        // METHOD ONE
        String out_one = useNewCharArray(s);
        System.out.println(out_one);


        // METHOD TWO
        String out_two = useReverseArrayLogic(s);
        System.out.println(out_two);

        //METHOD THREE
        String out_three = useCharAt(s);
        System.out.println(out_three);

    }

    private static String useCharAt(String s) {

        StringBuilder builder = new StringBuilder();

        for(int i= s.length() -1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    private static String useReverseArrayLogic(String s) {
        char[] chars = s.toCharArray();

        int number_of_swaps_required = (chars.length)/2;

        int last_index;
        char temp;

        for(int start_index = 0; start_index < number_of_swaps_required; start_index++) {

            last_index = chars.length -start_index -1;

            temp = chars[start_index];
            chars[start_index] = chars[last_index];
            chars[last_index] = temp;
        }

        return String.copyValueOf(chars);
    }

    private static String useNewCharArray(String s) {
        char[] chars = s.toCharArray();

        char[] reverseChar = new char[chars.length];
        int j=0;

        for(int i= chars.length -1; i >=0; i--,j++) {
            reverseChar[j] = chars[i];
        }

        return String.copyValueOf(reverseChar);
    }
}
