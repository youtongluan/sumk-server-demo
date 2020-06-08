package org.test.rpc;

import org.test.action.HelloAction;
import org.yx.annotation.Bean;
import org.yx.annotation.rpc.SoaClass;

@Bean
@SoaClass
public class HelloActionImpl implements HelloAction {

	@Override
	public String reply(String msg) {
		return "reply for "+msg;
	}

}
