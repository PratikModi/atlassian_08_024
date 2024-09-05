package com.java.atlassian;

public interface IRateLimiter {
    boolean checkLimit(int customerId);
}
