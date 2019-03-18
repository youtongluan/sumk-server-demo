package org.test.login;

import org.yx.annotation.Bean;
import org.yx.annotation.http.Web;
import org.yx.http.HttpSessionHolder;
import org.yx.http.filter.SessionObject;

@Bean
public class UserAction {

	@Web(requireLogin=true)
	public String userInfo() {
		return "用户id："+HttpSessionHolder.getUserObject(SessionObject.class).getUserId();
	}
}
