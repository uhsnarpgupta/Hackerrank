import java.util.HashSet;
import java.util.Set;

public class UnsimilarCharInStrings {
    public static void main(String[] args) {
        String s1 = "Hello World!";
        String s2 = "Bye world";

        printNonSimilarChars(s1, s2);
    }

    private static void printNonSimilarChars(String s1, String s2) {
        //s1 = s1.toLowerCase();
        //s2 = s2.toLowerCase();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int len1 = c1.length;
        int len2 = c2.length;

        Set<Character> disjointArr = new HashSet<>();
        int k = 0;
        if (len1 > len2) {
            //disjointArr = new int[len1];
            for (int i = 0; i < len1; i++) {
                int p = -1;
                for (int j = 0; j < len2; j++) {
                    if (c1[i] != c2[j]) {
                        p = 0;
                    } else {
                        p = -1;
                        break;
                    }
                }
                if (p == 0) {
                    //disjointArr[k++] = c2[i];
                    disjointArr.add(c1[i]);
                }
            }
            for (int i = 0; i < len2; i++) {
                int p = -1;
                for (int j = 0; j < len1; j++) {
                    if (c2[i] != c1[j]) {
                        p = 0;
                    } else {
                        p = -1;
                        break;
                    }
                }
                if (p == 0)
                    //disjointArr[k++] = c2[i];
                    disjointArr.add(c2[i]);
            }
        } else {
            //disjointArr = new int[len2];
            for (int i = 0; i < len2; i++) {
                int p = -1;
                for (int j = 0; j < len1; j++) {
                    if (c2[i] != c1[j]) {
                        p = 0;
                    } else {
                        p = -1;
                        break;
                    }
                }
                if (p == 0)
                    //disjointArr[k++] = c2[i];
                    disjointArr.add(c2[i]);
            }
        }
        for (int i = 0; i < len1; i++) {
            int p = -1;
            for (int j = 0; j < len2; j++) {
                if (c1[i] != c2[j]) {
                    p = 0;
                } else {
                    p = -1;
                    break;
                }
            }
            if (p == 0)
                //disjointArr[k++] = c1[i];
                disjointArr.add(c1[i]);
        }
        disjointArr.forEach(System.out::println);
        System.out.println(disjointArr.size());
    }
}

/*
1.Given two strings.Print characters from first string which are not in second string.
 */