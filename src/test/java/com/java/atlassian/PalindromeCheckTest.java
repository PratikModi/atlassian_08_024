package com.java.atlassian;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheckTest {

    @Test
    public void testIfPalindrome(){

        PalindromeCheck check = new PalindromeCheck();

        String word = "BOB";
        Assert.assertEquals(true, check.checkIfPalindrome(word));
    }

    @Test
    public void testIfPalindrome1()
    {

        PalindromeCheck check = new PalindromeCheck();

        String word = "HELLO";
        Assert.assertEquals(false, check.checkIfPalindrome(word));
    }

    @Test
    public void testIfPalindrome2()
    {

        PalindromeCheck check = new PalindromeCheck();

        String word = null;
        Assert.assertEquals(false, check.checkIfPalindrome(word));
    }

    @Test
    public void testIfPalindrome3()
    {

        PalindromeCheck check = new PalindromeCheck();

        String word = "";
        Assert.assertEquals(true, check.checkIfPalindrome(word));
    }

    @Test
    public void testIfPalindrome4()
    {

        PalindromeCheck check = new PalindromeCheck();

        String word = "     ";
        Assert.assertEquals(true, check.checkIfPalindrome(word));
    }
}
