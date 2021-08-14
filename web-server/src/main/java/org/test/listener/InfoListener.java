package org.test.listener;

import java.util.Arrays;
import java.util.Collection;

import org.test.Constants;
import org.yx.annotation.Bean;
import org.yx.common.listener.SumkListener;
import org.yx.log.Log;

//监听数据表的变更
@Bean
public class InfoListener implements SumkListener {

	/*
	 * 使用EventBus将listen_info事件发布出去，就可以在这里监听到
	 */
	@Override
	public Collection<String> acceptType() {
		return Arrays.asList(Constants.LISTEN_TYPE);
	}
	
	@Override
	public void listen(Object ev) {
		Log.get("listen").info("监听到了事件：{}",ev);
	}

}
