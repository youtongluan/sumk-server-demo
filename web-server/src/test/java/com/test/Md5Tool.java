package com.test;

import java.nio.charset.StandardCharsets;

import org.yx.util.S;

public class Md5Tool {
	public static void main(String[] args) throws Exception {
		System.out.println(S.hasher.digest("helloworld",StandardCharsets.UTF_8));
	}
}
