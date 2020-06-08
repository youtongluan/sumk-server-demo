package org.test.web;

import java.util.Date;

import org.test.action.HelloAction;
import org.test.pojo.Student;
import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.annotation.Inject;
import org.yx.annotation.http.Web;
import org.yx.db.DB;
import org.yx.log.Log;
import org.yx.rpc.client.Rpc;
import org.yx.util.S;
/*
 * 因为下列接口使用了微服务，要访问下列接口，需要做以下操作：
 * 1、启动zookeeper
 * 2、启动rpc-server
 * 3、去掉soa.client.start和sumk.zkurl的注释，然后启动Bootstrap
 */
@Bean
public class SoaClientAction {

	@Inject
	private HelloAction helloAction;
	
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
		Student s2 = S.json().fromJson(ret, Student.class);
		Log.get(this.getClass()).info("rpc返回的结果是:{}", ret);
		DB.insert(s2).execute();
		return s2;
	}

	// http://localhost:8081/rest/echoFromRpc?data={"name":"游夏"}
	@Web
	public String echoFromRpc(String name) {
		String ret = Rpc.call("a.b.c", name);
		return S.json().fromJson(ret, String.class);
	}
	
	// http://localhost:8081/rest/echo/by/intf
	@Web("echo/by/intf")
	public String echoByIntf() {
		/*
		 * 不需要对返回值做json处理，如果返回的是泛型，要做如下处理（只要全局做一次就可以）：
		 * 比如返回List<SumkDate>，就要将这个类型进行注册 
		 * JsonTypes.registe(new TypeToken<List<SumkDate>>(){}.getType());
		 */
		return this.helloAction.reply("接口方式的微服务");
	}
}
