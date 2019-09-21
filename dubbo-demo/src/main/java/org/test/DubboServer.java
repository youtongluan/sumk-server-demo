package org.test;

import org.yx.main.SumkServer;

public class DubboServer {
	public static void main(String[] args) throws InterruptedException {
		SumkServer.startAsTool();
		Thread.currentThread().join();
	}
}
