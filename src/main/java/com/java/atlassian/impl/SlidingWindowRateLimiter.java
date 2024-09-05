package com.java.atlassian.impl;

import com.java.atlassian.IRateLimiter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


/**
 * 10 -- Limit
 * 10:00:01
 * 10:00:05
 * 10:00:10
 * 10:00:50
 * 10:00:59
 * 10:01:02 -- 1  == 10:00:02 --- CurrentTime --> 5 == 10-5
 *
 * FixWindow --
 *
 * X-Limit
 * X-WaitTime
 *
 */

public class SlidingWindowRateLimiter implements IRateLimiter {

    private int limit; //X
    private Long time; //Y
    private TimeUnit timeUnit;
    private Map<Integer, List<Long>> customerRateLimitMap;
    private Supplier<Long> clientTime;
    private int quota_limit = 50;

    public SlidingWindowRateLimiter(int limit, Long time, TimeUnit timeUnit,Supplier<Long> supplier) {
        this.limit = limit;
        this.time = time;
        this.timeUnit = timeUnit;
        this.customerRateLimitMap = new ConcurrentHashMap<>();
        this.clientTime = supplier;
    }

    public SlidingWindowRateLimiter(int limit, Long time, TimeUnit timeUnit) {
        this.limit = limit;
        this.time = time;
        this.timeUnit = timeUnit;
        this.customerRateLimitMap = new ConcurrentHashMap<>();
    }

    public SlidingWindowRateLimiter() {
        this.limit = 5;
        this.time = 1L;
        this.timeUnit = TimeUnit.SECONDS;
        this.customerRateLimitMap = new ConcurrentHashMap<>();
    }

    public SlidingWindowRateLimiter(Supplier<Long> supplier) {
        this.limit = 5;
        this.time = 1L;
        this.timeUnit = TimeUnit.SECONDS;
        this.customerRateLimitMap = new ConcurrentHashMap<>();
        this.clientTime = supplier;
    }

    @Override
    public boolean checkLimit(int customerId) {
        Long reqTime = Instant.now().toEpochMilli();
        if(clientTime!=null){
            System.out.println(clientTime.get());
            reqTime = clientTime.get();
        }
        if(!customerRateLimitMap.containsKey(customerId)){
            List<Long> logTimes = new ArrayList<>();
            logTimes.add(reqTime);
            customerRateLimitMap.put(customerId,logTimes);
            return true;
        }else{
            List<Long> logTimes = customerRateLimitMap.get(customerId);
            logTimes.add(reqTime);
            if(logTimes.size()<=limit)
                return true;
            else{
                Long windowTime = reqTime - timeUnit.toMillis(time);
                Iterator<Long> iterator = logTimes.iterator();
                int quota=0;
                while(iterator.hasNext()){
                    Long lTime = iterator.next();
                    if(lTime>windowTime && lTime<=reqTime){
                        if(quota<quota_limit) {
                            quota++;
                        }
                    }
                }
                System.out.println(quota);
                logTimes.removeIf(t->t<windowTime); // TTL --
                if(logTimes.size()<=limit+quota) /// remove empty entries -- Background running thread
                    return true;
            }
        }
        return false;
    }
}
