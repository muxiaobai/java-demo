package io.github.muxiaobai.tool.guava.limit;

import cn.hutool.Hutool;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 等待，所有的线程在1，await等待，直到 最后一个await到0 一起出发
 * 发令枪
 */
public class CyclicBarrierDemo {

    /*并发设置为1000*/
    private static final int nums = 100;

    private static  CyclicBarrier cyclicBarrier = new CyclicBarrier(nums + 1);

    private  static  AtomicInteger i = new AtomicInteger();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < nums; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("1,run:" + Thread.currentThread().getName());

                    System.out.println(cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                    System.out.println(cyclicBarrier.getNumberWaiting());

                    /// 都在这里等着，所有的执行完了再开始执行
                    System.out.println("2,run:" + Thread.currentThread().getName());
                    // http://192.168.120.61:8083/openlab_web/openapp/app/appmanage/workBenchData
//                    String url = "http://192.168.120.61:8083/openlab_web/openapp/system/index";
//                    HttpRequest request = HttpUtil.createPost(url);
//                    request.header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb21lRnJvbSI6Ik9QRU5BUFAiLCJleHAiOjE1OTY3MTE1OTEsInVzZXJJZCI6IjQ5ZjgxMzgyMjA0ZjRmZGY5YmFhOGNhZmM4N2RkYmFiIiwidXNlcm5hbWUiOiJhZG1pbiJ9.96vA_lia2p3EoRGER4VZB-QcGUnQ2U8W0Hjx56R1sEE");
//                    HttpResponse response = request.execute();
//                    String url ="http://192.168.160.23:18201/dict";
                    String url ="http://192.168.160.23:18201/search/search/queryPage";

                    HttpRequest request = HttpUtil.createPost(url);
                    request.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            System.out.println(cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await();
            System.out.println(cyclicBarrier.getNumberWaiting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    /**
     * 设置代理
     * @param httpGet
     * @param proxyIp
     * @param proxyPort
     * @return
     */
    public static CloseableHttpClient setProxy(HttpGet httpGet, String proxyIp, int proxyPort){
        // 创建httpClient实例
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //设置代理IP、端口
        HttpHost proxy=new HttpHost(proxyIp,proxyPort,"http");
        //也可以设置超时时间   RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).setConnectTimeout(3000).setSocketTimeout(3000).setConnectionRequestTimeout(3000).build();
        RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        return httpClient;
    }
}
