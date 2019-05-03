package org.test.web;

import java.util.Date;

import org.test.pojo.Student;
import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.annotation.http.Web;
import org.yx.db.DB;
import org.yx.log.Log;
import org.yx.rpc.client.Rpc;
import org.yx.util.JsonUtil;
/*
 * 因为下列接口使用了微服务，要访问下列接口，需要做以下操作：
 * 1、启动zookeeper
 * 2、启动rpc-server
 * 3、去掉soa.client.start和sumk.zkurl的注释，然后启动Bootstrap
 */
@Bean
public class SoaClientAction {

	// http://localhost:8081/rest/insertStudent?data={"name":"游夏","age":20}
	@Web
	@Box
	public Student insertStudent(String name, Integer age) {
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		student.setLastUpdate(new Date());
		String ret = Rpc.create("fillStudent").callback(r -> {
			Log.get(SoaClientAction.class).info("rpc返回的结果是:{}", r.json());
		}).paramInArray(student).execute().getOrException();
		Student s2 = JsonUtil.fromJson(ret, Student.class);
		Log.get(this.getClass()).info("rpc返回的结果是:{}", ret);
		DB.insert(s2).execute();
		return s2;
	}

	// http://localhost:8081/rest/echoFromRpc?data={"name":"游夏"}
	@Web
	public String echoFromRpc(String name) {
		String ret = Rpc.call("echo", name);
		return JsonUtil.fromJson(ret, String.class);
	}
}
