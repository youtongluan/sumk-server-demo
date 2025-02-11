package org.test;

import java.util.Arrays;

import org.yx.main.SumkServer;

public class Bootstrap {

	public static void main(String[] args) {
		SumkServer.start(Bootstrap.class, Arrays.asList(args));
	}

}
