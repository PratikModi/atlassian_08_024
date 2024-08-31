package com.java.atlassian;

import java.sql.SQLOutput;

public class FibonacciSeries {

    public void fibonacci(int n){
        int prevFirst =0;
        int prevSecond = 1;
        if(n==0)
            System.out.println("0");
        if(n>0)
            System.out.println(prevFirst);
            int seriesNum = prevFirst+prevSecond;
            prevFirst=prevSecond;
            prevSecond = seriesNum;
            fibonacci(n-1);
        }


    public int fibonacciRecursive(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }





    public static void main(String[] args) {
        FibonacciSeries series = new FibonacciSeries();
        series.fibonacci(6);
    }

}
