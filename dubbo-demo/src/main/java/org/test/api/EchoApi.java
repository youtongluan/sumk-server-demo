package org.test.api;

import java.sql.SQLException;

public interface EchoApi {
	String hello(String name) throws SQLException;
}
