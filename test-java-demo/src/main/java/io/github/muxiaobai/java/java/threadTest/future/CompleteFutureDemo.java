/**
 * Project Name:ProjectTest
 * File Name:CompleteFutureDemo.java
 * Package Name:io.github.muxiaobai.java.java.threadTest
 * Date:2019年4月12日下午6:07:35
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package io.github.muxiaobai.java.java.threadTest.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ClassName:CompleteFutureDemo 
 * Function: TODO 
 * Reason:	 TODO 
 * Date:     2019年4月12日 下午6:07:35 
 * @author   Mu Xiaobai
 * @version  
 * @since    JDK 1.8	 
 */
public class CompleteFutureDemo {
    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }
    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> f = compute();
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        f.complete(100);
        //f.completeExceptionally(new Exception());
        System.in.read();
    }
}
class Client extends Thread {
    CompletableFuture<Integer> f;
    Client(String threadName, CompletableFuture<Integer> f) {
        super(threadName);
        this.f = f;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.getName() + ": " + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}