package com.java.atlassian;

public class PalindromeCheck {
    public Boolean checkIfPalindrome(String word){
        if(word == null )
            return false;
        if(word.isBlank())
            return true;
        int n = word.length();
        for(int i=0;i<n/2;i++){
            if(word.charAt(i)!=word.charAt(n-i-1))
                return false;
        }
        return true;
    }
}


