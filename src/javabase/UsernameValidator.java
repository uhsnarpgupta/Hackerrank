package javabase;

import java.util.Scanner;


/*
1. The username consists of 8 to 30 characters inclusive.
If the username consists of less than 8 or greater than 30 characters, then it is an invalid username.
2. The username can only contain alphanumeric characters and underscores (_).
3. Alphanumeric characters describe the character set consisting of lowercase characters [a-z], uppercase characters [A-Z], and digits [0-9].
4. The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or uppercase character [A-Z].

    Username            Validity
	Julia               INVALID; Username length < 8 characters
	Samantha            VALID
	Samantha_21         VALID
	1Samantha           INVALID; Username begins with non-alphabetic character
	Samantha?21_2A      INVALID; '?' character not allowed

*/
public class UsernameValidator {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(Validator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

class Validator{
    public static final String regularExpression = "^[a-zA-Z]\\w{7,29}$";
}