package javabase;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateRemover {
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";

        /*
        The pattern above basically means to capture any pattern where a word ((\w+)) is followed by non-word character (e.g., space)
        then by itself again (\1 is the backreference to (\w+) earlier).
        So for the example input"Goodbye bye bye world world world", the matcher will find 3 patterns:
        1) Goodbye
        2) bye bye
        3) world world world
        Then for each of them, we can call replaceAll to replace the whole group with the first group (i.e., the first word - m.group(1)).
        */
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}
