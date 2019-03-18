package org.test.web;

import java.util.Date;

import org.test.pojo.Student;
import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.annotation.http.Web;
import org.yx.db.DB;
import org.yx.log.Log;
import org.yx.rpc.client.Rpc;
import org.yx.util.GsonUtil;

@Bean
public class SoaClientAction {

	@Web
	@Box
	public Student insertStudent(String name,Integer age) {
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		student.setLastUpdate(new Date());
		String ret = Rpc.call("fillStudent",student);
		Student s2=GsonUtil.fromJson(ret, Student.class);
		Log.get(this.getClass()).info("rpc返回的结果是:{}",ret);
		DB.insert(s2).execute();
		return s2;
	}
	
	@Web
	public String echoFromRpc(String name) {
		String ret = Rpc.sender("echo").callback(r->{
			Log.get(SoaClientAction.class).info("rpc返回的结果是:{}",r.json());
		}).execute().getOrException();
		DB.insert(ret).execute();
		return ret;
	}
}
