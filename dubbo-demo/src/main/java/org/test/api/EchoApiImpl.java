package org.test.api;

import java.sql.SQLException;

import org.yx.annotation.Box;
import org.yx.bean.IOC;
import org.yx.util.S;
import org.yx.util.SumkDate;

public class EchoApiImpl implements EchoApi{

	private StudentDao dao=IOC.get(StudentDao.class);
	
	@Box
	@Override
	public String hello(String name) throws SQLException {
		Student user = new Student();
		user.setAge(123);
		user.setName(name);
		user.setLastUpdate(SumkDate.now().toDate());
		Student user2=dao.insertAndQuery(user);
		return S.json.toJson(user2);
	}

}
