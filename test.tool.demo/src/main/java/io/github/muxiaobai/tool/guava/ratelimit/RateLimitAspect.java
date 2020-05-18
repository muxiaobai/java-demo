package io.github.muxiaobai.tool.guava.ratelimit;

import org.mp4parser.aspectj.lang.ProceedingJoinPoint;

public class RateLimitAspect {
    private RateLimitConfig config;
    private RateLimitService rateLimitService;
    public RateLimitAspect(RateLimitConfig config, RateLimitService rateLimitService) {
        this.config = config;
        this.rateLimitService = rateLimitService;
    }
    public void executionMethod() {}
    public Object doRateLimit(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        // 判断是否限流
        try {
            if (config.isDoRateLimit()) {
                // 开启限流
                boolean acquireResult = false;
                // 1.查看是否配置超时时间
                if (config.getWaitTimeout() == 0L) {
                    // 2.获取令牌
                    acquireResult = rateLimitService.tryAcquire();
                } else {
                    // 2.获取令牌，超时时间内获取令牌
                    acquireResult = rateLimitService.acquire(config.getWaitTimeout());
                }
                if (acquireResult) {
                    // 3.成功获取令牌，放行
                    result = pjp.proceed();
                } else {
                    // 3.失败获取令牌，返回错误码 429 => to many requests
//                    result = ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
                    return "429";
                }
            } else {
                // 无开启限流，直接放行
                result = pjp.proceed();
            }
        } catch (Throwable e) {
            throw e;
        }
        return result;
    }
}