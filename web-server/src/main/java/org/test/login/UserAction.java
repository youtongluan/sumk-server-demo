package org.test.login;

import org.yx.annotation.Bean;
import org.yx.http.WebUtil;
import org.yx.http.user.SessionObject;

@Bean
public class UserAction {

	// http://localhost:8081/rest/userInfo
	public String userInfo() {
		//这个方式可以获取到session对象。可以继承SessionObject来扩展字段
		SessionObject session=WebUtil.getUserObject(SessionObject.class);
		return "用户id："+session.getUserId();
	}
}
