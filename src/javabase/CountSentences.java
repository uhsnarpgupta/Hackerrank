package javabase;

import java.util.*;

public class CountSentences {
    public static void main(String[] args) {
        String str = "Cat the bats";
        List<String> words = new ArrayList<>();
        words.add("the");
        words.add("bats");
        words.add("tabs");
        words.add("in");
        words.add("cat");
        words.add("act");
        System.out.println(countsentences(words,str));
    }

    public static double countsentences(List<String> wordSet, String str){
        Set<String> set = new HashSet<>(wordSet);
        String [] sentence = str.split(" ");
        Map<String, Set<String>> map = new HashMap<>();
        for(String t: sentence){
            Set<String> anagrams = new HashSet<>();
            for(String word : wordSet){
                if(isAnagram(t,word) && !t.equalsIgnoreCase(word)){
                    anagrams.add(word);
                }
            }
            if(anagrams.size()!=0)
                map.put(t,anagrams);
        }
        int count = 1;
        for (String name : map.keySet()){
            count *= map.get(name).size() + 1;
        }
        if(map.size() == 0){
            return 1;
        }
        else{
            return count;
        }

    }

    static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        char[] first = a.toLowerCase().toCharArray();
        char[] second = b.toLowerCase().toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < first.length; i++) {
            counts[first[i] - 97]++;
            counts[second[i] - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0)
                return false;
        }
        return true;
    }
}
