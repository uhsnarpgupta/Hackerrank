package stack.palindrome;

import java.util.LinkedList;

public class CheckPalindrome {
    public static void main(String[] args) {
        String input = "I did, Did I?";
        //input.concat("as");
        String processedInput = input.replaceAll("[^a-zA-Z]||\\s", "").toLowerCase();
        char[] charArray = processedInput.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        char[] newArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            if (((Character) charArray[i]).equals(list.peek())) {
                list.pop();
            } else {
                list.push(charArray[i]);
            }
        }
        if (list.isEmpty()) {
            System.out.println("input is a palindrome ");
        } else {
            System.out.println("input isn't a palindrome ");
        }
    }
}
