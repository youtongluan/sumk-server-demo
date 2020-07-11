package com.test;

import org.junit.Test;
import org.test.pojo.Student;
import org.yx.sumk.code.CodeTool;

public class CodeToolTest {

	
	//要在bean生成之后
	@Test
	public void generateDao(){
		CodeTool.generateDao(false,Student.class);
	}
	
	@Test
	public void generateDBTable(){
		CodeTool.generateDBTable();
	}

}
