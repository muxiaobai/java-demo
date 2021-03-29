package io.github.muxiaobai.tool.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Zhang Pengfei
 * @version V1.0
 * @PROJECT_NAME java-demo
 * @Package io.github.muxiaobai.java.httpclient
 * @date 2021/3/26/026 15:15
 */
public class HttpClientProxy {

    public  String HttpGet(String url,String data){
        try {
//	        HttpClient httpClient = new DefaultHttpClient();
//        CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建POST请求对象

            CredentialsProvider provider = new BasicCredentialsProvider();
            //包含账号密码的代理
            provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("username",
                    "password"));
            CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(provider).build();
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            HttpGet httpGet =  new HttpGet(url);
//        httpPost.setConfig(config);

            /*
             * 添加请求头信息
             */
            httpGet.addHeader("Content-Type", "application/json");
            //设置请求参数
//            setPostData(httpGet, data);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            //发送请求
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取请求返回体
            String backResult =  EntityUtils.toString(httpEntity,"UTF-8");
            //请求返回结果
            System.out.print(backResult);
            if(httpResponse != null){
                try{
                    EntityUtils.consume(httpResponse.getEntity());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }//释放资源
            return backResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";

    }
    public  String HttpPost(String url,String data){
        try {
//	        HttpClient httpClient = new DefaultHttpClient();
//        CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建POST请求对象

            CredentialsProvider provider = new BasicCredentialsProvider();
            //包含账号密码的代理
            provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("username",
                    "password"));
            CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(provider).build();
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            HttpPost httpPost =  new HttpPost(url);
//        httpPost.setConfig(config);

            /*
             * 添加请求头信息
             */
            httpPost.addHeader("Content-Type", "application/json");
            //设置请求参数
            setPostData(httpPost, data);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            //发送请求
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取请求返回体
            String backResult =  EntityUtils.toString(httpEntity,"UTF-8");
            //请求返回结果
            System.out.print(backResult);
            if(httpResponse != null){
                try{
                    EntityUtils.consume(httpResponse.getEntity());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }//释放资源
            return backResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";

    }

    //设置请求参数
    private static void setPostData(HttpPost httpPost, String data){
//	        /*另外一种设置请求参数方法*/
//	        List<NameValuePair> list = new ArrayList<NameValuePair>();
//	        for (Map.Entry<String, String> entry : params.entrySet()) {
//	            list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
//	        }
//	        HttpEntity httpEntity = null;
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(data, "UTF-8");
//	            httpEntity = new UrlEncodedFormEntity(list, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);//设置请求主体
    }
}
