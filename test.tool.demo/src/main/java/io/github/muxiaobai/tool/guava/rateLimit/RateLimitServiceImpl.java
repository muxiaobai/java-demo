package io.github.muxiaobai.tool.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;


public class RateLimitServiceImpl implements RateLimitService {
    private RateLimitConfig config;
    private RateLimiter rateLimiter;
    public RateLimitServiceImpl(RateLimitConfig config) {
        this.config = config;
        this.rateLimiter = RateLimiter.create(this.config());
    }
    @Override
    public boolean tryAcquire() {
        return this.tryAcquire(1);
    }
    @Override
    public boolean tryAcquire(int permits) {
        return rateLimiter.tryAcquire(permits);
    }
    @Override
    public boolean acquire(long timeout) {
        return this.acquire(1, timeout);
    }
    @Override
    public boolean acquire(int permits, long timeout) {
        long start = System.currentTimeMillis();
        for (;;) {
            boolean tryAcquire = rateLimiter.tryAcquire(permits);
            if (tryAcquire) {
                return true;
            }
            long end = System.currentTimeMillis();
            if ((end - start) >= timeout) {
                return false;
            }
        }
    }
}