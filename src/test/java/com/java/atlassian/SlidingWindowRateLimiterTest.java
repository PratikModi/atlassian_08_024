package com.java.atlassian;

import com.java.atlassian.impl.SlidingWindowRateLimiter;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class SlidingWindowRateLimiterTest {

    @Test
    public void checkLimit() throws Exception {
        IRateLimiter rateLimiter = new SlidingWindowRateLimiter(2, 1L, TimeUnit.SECONDS);
        for (int i = 0; i < 3; i++) {
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println(result);
        }
        //True
        //True
        //False
    }
    @Test
    public void checkLimit2() throws Exception {
        IRateLimiter rateLimiter = new SlidingWindowRateLimiter(3, 1L, TimeUnit.SECONDS);
        for (int i = 0; i < 3; i++) {
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(result);
        }

    }
    //1 -- 1L
    // 500 MS
    // 1  -1 --

    @Test
    public void checkLimit3() throws Exception{
        IRateLimiter rateLimiter = new SlidingWindowRateLimiter(1,1L, TimeUnit.SECONDS);
        for(int i=0;i<3;i++){
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(result);
        }
    }


    @Test
    public void checkLimitQuota() throws Exception{
        IRateLimiter rateLimiter = new SlidingWindowRateLimiter(10,1L, TimeUnit.SECONDS);
        for(int i=0;i<5;i++){
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(result);
        }
        TimeUnit.SECONDS.sleep(1);
        for(int i=0;i<17;i++){
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(result);
        }
    }


    @Test
    public void checkLimitQuota2() throws Exception{
        IRateLimiter rateLimiter = new SlidingWindowRateLimiter(10,1L, TimeUnit.SECONDS, ()-> Instant.now().toEpochMilli());
        for(int i=0;i<5;i++){
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(result);
        }
        TimeUnit.SECONDS.sleep(1);
        for(int i=0;i<17;i++){
            boolean result = rateLimiter.checkLimit(1);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(result);
        }
    }




}
