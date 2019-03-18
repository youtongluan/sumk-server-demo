package org.test.login;

import javax.servlet.http.HttpServletRequest;

import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.http.filter.AbstractSessionFilter;
import org.yx.http.filter.LoginObject;
import org.yx.http.filter.SessionObject;
import org.yx.log.Log;

//登录
@Bean
public class MyLoginServlet extends AbstractSessionFilter {

	@Box
	protected LoginObject login(String token, String user, HttpServletRequest req) {
		String password = req.getParameter("password");
		String validCode = req.getParameter("code");
		Log.get(this.getClass()).info("用户登录，user:{},password:{},code:{}",user,password,validCode);
		if (!"9999".equals(validCode)) {
			return LoginObject.error("验证码错误");
		}
		if ("admin".equals(user) && "123456".equals(password)) {
			SessionObject so = new SessionObject();
			so.setLoginTime(System.currentTimeMillis());
			so.setUserId("admin");
			this.userSession().setSession(token, so);
			return LoginObject.success(null, so.getUserId());
		}

		return LoginObject.error("用户名或密码错误");
	}

}
