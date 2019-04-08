package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CamelCasePatternMatching {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int wordCount = Integer.parseInt(br.readLine());
            String[] arr = (br.readLine()).split(" ");
            String pattern = br.readLine();
            System.out.println(checkForCamelCasePattern(pattern, arr));
        }
    }

    private static String checkForCamelCasePattern(String pattern, String[] arr) {
        StringBuilder sb = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        Map<String, String> patMap = new HashMap<>();

        for (String item : arr) {
            for (int i = 0; i < item.length(); i++) {
                char c = item.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    sb.append(c);
                }
            }
            if (sb.toString().startsWith(pattern)) {
                patMap.put(item, sb.toString());
                resultList.add(item);
            }
            sb = new StringBuilder();
        }

        if (resultList.size() > 0) {
            resultList.sort(Comparator.comparing(patMap::get));
            //resultList.sort((o1, o2) -> patMap.get(o1).compareTo(patMap.get(o2)));
            for (String st : resultList) {
                sb.append(st + " ");
            }
            return sb.toString().trim();
        }
        return "No match found";
    }
}

/*
Given a dictionary of words where each word follows CamelCase notation, print all words in the dictionary that match
with a given pattern consisting of uppercase characters only.

CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital
 letter. Common examples include: “PowerPoint” and “WikiPedia”, “GeeksForGeeks”, “CodeBlocks”, etc.

Input:
The first line of input contains an integer T denoting the number of test cases. Then the description of T test cases
follow. Each test case contains an integer n denoting the number of words in the dictionary. The next line contains the
vector of strings in the dictionary. The last line contains the pattern.

Output:
Print all words in the dictionary that match with a given pattern consisting of uppercase characters only. If the
pattern is not found, print "No match found" (without quotes).

Constraints:
1<=T<=100
1<=n<=100
1<=length of string<=100
1<=length of patter<=length of string<=100

Example:
Input:
2
8
Hi Hello HelloWorld HiTech HiGeek HiTechWorld HiTechCity HiTechLab
HA
3
WelcomeGeek WelcomeToGeeksForGeeks GeeksForGeeks
WTG

Output:
No match found
WelcomeToGeeksForGeeks
 */