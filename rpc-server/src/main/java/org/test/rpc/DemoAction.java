package org.test.rpc;

import java.util.Date;

import org.test.pojo.Student;
import org.yx.annotation.Bean;
import org.yx.annotation.Param;
import org.yx.annotation.rpc.Soa;
import org.yx.log.Log;
import org.yx.util.S;
import org.yx.util.SeqUtil;

@Bean
public class DemoAction {

	@Soa("a.b.c")
	public String echo(@Param(required=true,cnName="名字") String name) {
		return "你好 "+name;
	}
	
	@Soa
	public Student fillStudent(Student student) {
		student.setId(SeqUtil.next());
		student.setLastUpdate(new Date());
		Log.get(this.getClass()).info(S.json.toJson(student));
		return student;
	}
	
}
