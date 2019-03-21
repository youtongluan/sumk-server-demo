package org.test.login;

import org.yx.annotation.Bean;
import org.yx.annotation.http.Web;
import org.yx.http.user.SessionObject;
import org.yx.http.user.WebSessions;

@Bean
public class UserAction {

	// http://localhost:8081/rest/userInfo
	@Web(requireLogin=true)
	public String userInfo() {
		return "用户id："+WebSessions.getUserObject(SessionObject.class).getUserId();
	}
}
