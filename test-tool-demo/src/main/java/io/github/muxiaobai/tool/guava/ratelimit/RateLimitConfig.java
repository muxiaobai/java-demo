package io.github.muxiaobai.tool.guava.ratelimit;


import lombok.Data;

import java.io.Serializable;
@Data
public class RateLimitConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean           doRateLimit      = false;
    private long              waitTimeout;
    private long              permitsPerSecond;
}