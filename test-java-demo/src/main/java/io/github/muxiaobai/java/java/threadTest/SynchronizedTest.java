package io.github.muxiaobai.java.java.threadTest;

/** 
 * 
 * @author zhang
 * @date  2016年7月22日 下午4:03:07
 *
 */

public class SynchronizedTest {
	  private static int NUM_OF_THREAD = 1000;
	    static Thread[] threads = new Thread[NUM_OF_THREAD];
	    
	    public static void main(String[] args){
	        final Account acc = new Account("John", 1000.0f);
	        for (int i = 0; i< NUM_OF_THREAD; i++) {
	            threads[i] = new Thread(()->{
	                        acc.deposit(100.0f);
	                        acc.withdraw(100.0f);
	            });
	            threads[i].start();
	        }

	        for (int i=0; i<NUM_OF_THREAD; i++){
	            try {
	                threads[i].join(); //等待所有线程运行结束
	            } catch (InterruptedException e) {
	                // ignore
	            }
	        }
	        System.out.println("Finally, John's balance is:" + acc.getBalance());
	    }
}
class Account {
    String name;
    float amount;
    
    
    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public  void  deposit(float amt) {
        float tmp = amount;
        tmp += amt;
        
        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        	
        }
        System.out.println("==method:"+"deposit=="+"amount:"+amount);
        amount = tmp;
    }

    public  void withdraw(float amt) {
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        }        
        System.out.println(" ==method:"+"withdraw =="+"amount:"+amount);
        amount = tmp;
    }

    public float getBalance() {
        return amount;
    }
}


