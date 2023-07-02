package algorithmicTasks;

import java.util.Locale;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        String result =  s.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z0-9]", "");
        if (result.equals("")) {
            return true;
        }
        for (int i = 0; i <= result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
