package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;
import org.yx.common.lock.Lock;
import org.yx.common.util.S;
import org.yx.log.LogLevel;
import org.yx.log.Loggers;
import org.yx.main.SumkServer;

public class LockTest {

	int c;
	
	@Test
	public void test() throws InterruptedException {
		SumkServer.startAsTool();
		final int count=200;
		CountDownLatch counter=new CountDownLatch(count);
		long time=System.currentTimeMillis();
		ExecutorService es=Executors.newFixedThreadPool(10);
		final String kkk="key_"+System.currentTimeMillis();
		System.out.println("用做锁的key是："+kkk);
		Loggers.setDefaultLevel(LogLevel.DEBUG);
		for(int i=0;i<count;i++){
			es.submit(()->{
				long begin=System.currentTimeMillis();
				try (Lock k=S.lock().tryLock(kkk,5000)){
					if(k==null){
						System.out.println("获取key超时了,耗时(ms)："+(System.currentTimeMillis()-begin));
					}else{
						c++;
						System.out.print(" "+c+" ");
					}
					counter.countDown();
				}
			});
		}
		counter.await();
		System.out.println("耗时(ms)："+(System.currentTimeMillis()-time));
		Assert.assertEquals(count,c);
	}

}
