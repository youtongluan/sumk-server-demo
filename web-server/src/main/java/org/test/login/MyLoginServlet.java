package org.test.login;

import javax.servlet.http.HttpServletRequest;

import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.http.user.AbstractLoginServlet;
import org.yx.http.user.LoginObject;
import org.yx.http.user.SessionObject;
import org.yx.log.Log;

//登录,http://localhost:8081/login?username=admin&password=123456&code=9999
@Bean
public class MyLoginServlet extends AbstractLoginServlet {

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
