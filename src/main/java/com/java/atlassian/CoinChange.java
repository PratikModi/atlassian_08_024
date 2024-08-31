package com.java.atlassian;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        System.out.println(findWays(new int[]{1,3,4},3));
    }


    public static int findWays(int[] coins, int n){
        if(coins==null || coins.length==0)
            return 0;
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){ // 1,3,4
            for(int j = coins[i];j<=n;j++){ //1-->5
                dp[j]+=dp[j-coins[i]];
            }
        }
        Arrays.stream(dp).forEach(e-> System.out.println("==="+e));
        return dp[n]*(dp[n]-1);
    }

}
