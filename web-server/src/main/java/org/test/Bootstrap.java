package org.test;

import org.yx.conf.AppInfo;
import org.yx.log.Log;
import org.yx.main.SumkServer;

public class Bootstrap {

	public static void main(String[] args) {
		try {
			long begin=System.currentTimeMillis();
			SumkServer.start();
			Log.get(Bootstrap.class).info("启动完成,耗时：{}毫秒",System.currentTimeMillis()-begin);

			//这种写法是为了可以优雅退出，一般使用Thread.currentThread().join();就行了
			for(;;){
				if(AppInfo.getBoolean("stopServer", false)){
					SumkServer.stop();
					System.exit(-1);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			Log.printStack(e);
		}

	}

}
