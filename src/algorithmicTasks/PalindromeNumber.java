package algorithmicTasks;

//Given an integer x, return true if x is a
//        palindrome
//        , and false otherwise

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilderNum = new StringBuilder(Integer.toString(x));
        return stringBuilderNum.reverse().toString().equals(Integer.toString(x));
    }
}
