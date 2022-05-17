package io.github.muxiaobai.knowledge;

/**
 * @PROJECT_NAME java-demo
 * @date 2022/5/16/016 20:26
 * <p>
 * https://blog.csdn.net/lzy194/article/details/122231010
 * <p>
 * https://blog.csdn.net/qq_34827674/article/details/123463175
 * <p>
 * 缓存穿透
 * <p>
 * 非法请求限制， 业务直接判断，id不存在，小于0的不符合规则，
 * 一直请求一个id -1或者0，正常逻辑，查库，没有 返回，那么这个请求会一直落在数据库中
 * 查询出来-1没有一样存到缓存中，再次来的查询，就在缓存中查找到了数据直接返回。
 * <p>
 * <p>
 * 缓存击穿
 * 大量数据同一时间过期，请求直接落库，
 * <p>
 * 加锁，同一时间只有一个能获取到某一条数据
 * 缓存预热，自动续期，30分钟，
 * <p>
 * <p>
 * <p>
 * 缓存雪崩
 * 大量数据同时过期，
 * 过期时，设置随机时间，避免同时过期
 * 上集群
 * 服务限流
 *
 */
public class redis {

}
