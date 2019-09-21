package org.test.api;

import java.sql.SQLException;

import org.yx.annotation.Bean;
import org.yx.annotation.Box;
import org.yx.db.DB;

@Bean
public class StudentDao {
	
	@Box
	public Student insertAndQuery(Student user) throws SQLException{
		DB.insert(user).execute();//user没有指定id，系统会智能检测id并生成。
		DB.commit();
		return DB.select(Student.class).byPrimaryId(user.getId()).queryOne();
	}
}
