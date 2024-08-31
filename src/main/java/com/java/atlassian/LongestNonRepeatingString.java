package com.java.atlassian;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingString {
    //O(N)
    //O(N)

    public static String longestNonRepeating(String input){
        if(input==null || input.isBlank())
            return input;
        Map<Character,Integer> charIndex = new HashMap<>();
        int start=0;
        int end=0;
        int max=0;
        int i=0,j=0;

        //ababcda
        //i=0
        while(j<input.length()){
            if(charIndex.containsKey(input.charAt(j)) && charIndex.get(input.charAt(j))>=i){
                i = charIndex.get(input.charAt(j))+1;
            }else{
                charIndex.put(input.charAt(j),j++);
            }
            if((j-i)>=max){
                start=i;
                end=j;
                max=j-i;
            }
        }
        System.out.println(charIndex);
        System.out.println("==============");
        return input.substring(start,end);
    }

    public static void main(String[] args) {
        System.out.println(longestNonRepeating("adcbaf"));
        System.out.println(longestNonRepeating("ababcda"));
        System.out.println(longestNonRepeating("abcdefg"));
        System.out.println(longestNonRepeating("aaaaaa"));
    }

}
