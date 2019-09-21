package org.test.api;

import org.yx.annotation.Bean;
import org.yx.bean.Plugin;
import org.yx.log.Log;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

@Bean
public class DubboPlugin implements Plugin {

	@Override
	public void startAsync() {
		/*
		 * dubbo只支持使用原始对象，所以要直接暴露EchoApiImpl。
		 * 但是在EchoApiImpl内部，可以使用IOC去引用其它对象
		 */
		EchoApi xxxService = new EchoApiImpl();
		 
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("xxx");
		 
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		 
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(12345);
		protocol.setThreads(200);
		 
		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
		 
		// 服务提供者暴露服务配置
		ServiceConfig<EchoApi> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(EchoApi.class);
		service.setRef(xxxService);
		// 暴露及注册服务
		service.export();
		Log.get(this.getClass()).info("EchoApi 接口已经发布");
	}

	@Override
	public void stop() {

	}

}
