package org.test.web;

import org.test.pojo.Student;
import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.annotation.Param;
import org.yx.annotation.http.Web;
import org.yx.conf.AppInfo;
import org.yx.db.DB;
import org.yx.redis.RedisPool;

@Bean
public class DemoAction {

	@Web
	public String info(@Param(required=true,cnName="名字") String name, Integer age) {
		return "名字:"+name+",年龄:"+age;
	}
	
	@Web
	@Box
	public long insert(String name,Integer age) {
		Student user = new Student();
		user.setAge(age);
		user.setName(name);
		DB.insert(user).execute();//user没有指定id，系统会智能检测id并生成。
		return user.getId();
	}
	
	/*
	 * 访问地址：http://localhost:8081/rest/appInfo?data={"name":"test"}
	 * 在app.properties中修改test的值，过会儿再访问上述地址，可以看到返回值变化
	 */
	@Web
	public String appInfo(@Param(required=true,cnName="名字") String name) {
		return AppInfo.get(name);
	}
	
	@Web
	public long incrInRedis(String name) {
		return RedisPool.get("demo").incr(name);
	}
	
}
