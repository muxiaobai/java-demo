package io.github.muxiaobai.knowledge;

/**
 * @PROJECT_NAME java-demo
 * @date 2022/5/16/016 20:14
 * <p>
 * //    https://blog.csdn.net/weixin_44907128/article/details/124164030
 * <p>
 * 1消息不丢，2不会重复消费
 * <p>
 * 生产端 Broker 消费端
 * <p>
 * 开启确认 confirm
 * send发送ACK请求， Broker确认后返回ACK+SYN包， 确认后不再传输，否则继续传输
 * <p>
 * Broker
 * 队列持久化，消息持久化 deliverMode
 * <p>
 * 消费者 手动ack
 * pull 接收到消息后会给broker返回一个ACK+SYN包，如果没有收到则一直传输
 * <p>
 * <p>
 * 不重复消费 幂等性
 * insert 直接id幂等性
 * redis set 本身就是幂等性，重复设置无所谓，
 * 业务id，messageId ,重复发送， 消费端检测，已经有的进行redis查询 <id,message>,消费前先检查
 */
public class mq {
}
