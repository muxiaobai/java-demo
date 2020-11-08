package io.github.muxiaobai.tool.guava.limit;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.util.concurrent.*;


public class CountDownCyclicBarrier {

    //   private ExecutorService  executor = Executors.newFixedThreadPool(10);
    private ExecutorService executor = Executors.newCachedThreadPool();
//
//        executor.setCorePoolSize(5);//核心线程大小
//        executor.setMaxPoolSize(10);//最大线程大小
//        executor.setQueueCapacity(100);//队列最大容量
//        executor.setKeepAliveSeconds(3000);//存活时间
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝执行时如何处理
    /*并发设置为1000*/
    private static final int nums = 500;
    private CountDownLatch countDownLatch = new CountDownLatch(nums);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier (nums+1);

    public static void main(String[] args) {

        CountDownCyclicBarrier countDownCyclicBarrier = new CountDownCyclicBarrier ();
        countDownCyclicBarrier.test ();
    }
    private void testFireWall(){
        String url = "http://192.168.160.23:18201/search/search/queryPage";
        HttpRequest request = HttpUtil.createPost(url);
        request.header("Authorization","preview");
        request.header("owner", "1569092635");
        request.body("{\"indexId\":\"1\",\"keyWord\":\"禁止\",\"orderType\":\"score\",\"searchType\":\"text\",\"searchScope\":3,\"searchDateType\":\"year\",\"searchDateName\":\"时间不限\",\"beginDate\":\"\",\"endDate\":\"2020-03-12 15:38:22\",\"showId\":\"649da5e14d054167f7cc821dab0a6129\",\"owner\":\"1569092635\",\"page\":{\"current\":1,\"size\":20,\"pageSizes\":[2,5,10,20,50,100],\"total\":0,\"totalPage\":0,\"indexs\":[]}}");
        HttpResponse response = request.execute();
        System.out.println(response.body());
    }
    private void testRateLimit(){
        String url = "http://192.168.160.23:18201/search/manage/show/list";
        HttpRequest request = HttpUtil.createGet(url);
        request.header("Authorization","preview");
        request.header("owner", "1569092635");
        HttpResponse response = request.execute();
        System.out.println(response.body());
    }

    public void test(){
        Long start = System.currentTimeMillis ();
        for(int i  = 0;i<nums;i++){
            int temp = i;
//            executor.execute(()->{
//                try {
//                    System.out.println("threadName;" + Thread.currentThread().getName() + ",i:" + temp);
//                    countDownLatch.await();
////                    this.testFireWall();
//                    this.testRateLimit();
//                    System.out.println("ThreadName:" + Thread.currentThread().getName());
//                    cyclicBarrier.await();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            });
            Thread thread = new Thread(()->{
                try {
                    countDownLatch.await();
//                    this.testFireWall();
                    String url = "http://192.168.160.23:18201/search/search/queryPage";
                    HttpRequest request = HttpUtil.createPost(url);
                    request.header("Authorization","preview");
                    request.header("owner", "1569092635");
                    request.body("{\"indexId\":\"1\",\"keyWord\":\"禁止\",\"orderType\":\"score\",\"searchType\":\"text\",\"searchScope\":3,\"searchDateType\":\"year\",\"searchDateName\":\"时间不限\",\"beginDate\":\"\",\"endDate\":\"2020-03-12 15:38:22\",\"showId\":\"649da5e14d054167f7cc821dab0a6129\",\"owner\":\"1569092635\",\"page\":{\"current\":1,\"size\":20,\"pageSizes\":[2,5,10,20,50,100],\"total\":0,\"totalPage\":0,\"indexs\":[]}}");
                    HttpResponse response = request.execute();
                    System.out.println(response.body());

//                    String url = "http://192.168.160.23:18201/search/manage/show/list";
//                    HttpRequest request = HttpUtil.createGet(url);
//                    request.header("Authorization","preview");
//                    request.header("owner", "1569092635");
//                    HttpResponse response = request.execute();
//                    System.out.println(response.body());
//
//                    this.testRateLimit();
//                    System.out.println("ThreadName:"+Thread.currentThread().getName());
                    cyclicBarrier.await ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
//            executor.execute(thread);
            countDownLatch.countDown();
        }
        Long end = 0L ;
        try {
            cyclicBarrier.await();
            end = System.currentTimeMillis ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }
        System.out.println (end- start);
    }
}
