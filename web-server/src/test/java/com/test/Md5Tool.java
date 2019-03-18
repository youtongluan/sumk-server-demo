package com.test;

import org.yx.util.S;

public class Md5Tool {
	public static void main(String[] args) throws Exception {
		System.out.println(S.MD5.encrypt("helloworld".getBytes()));
	}
}
