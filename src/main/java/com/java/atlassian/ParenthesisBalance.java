package com.java.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ParenthesisBalance {
//O(N) -- N no of characters in input
//O(N) -- (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    public static boolean isBalance(String input){
        if(input==null || input.isBlank())
            return false;

        Map<Character,Character> openCloseMap = new HashMap<>();
        openCloseMap.put(')','(');
        openCloseMap.put('}','{');
        openCloseMap.put(']','[');

        Set<Character> openSet = Set.of('(','{','[');

        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(openSet.contains(c)){
                stack.push(c);
            }else{
                char open = openCloseMap.get(c);
                if(!stack.isEmpty() && stack.peek()==open){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
            return true;
    }


    public static void main(String[] args) {
        String input = "(){}[]";
        System.out.println(input+"-->"+isBalance(input));
        input = ")()";
        System.out.println(input+"-->"+isBalance(input));
        input ="({[]})";
        System.out.println(input+"-->"+isBalance(input));
        input ="({[)]}";
        System.out.println(input+"-->"+isBalance(input));
    }

}


