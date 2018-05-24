package top.stxkfzx.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
		Class.forName(prop.getProperty("mysqlDriver"));
		return DriverManager.getConnection(prop.getProperty("mysqlURL"), prop.getProperty("mysqlUser"), prop.getProperty("mysqlPassword"));
	}
	
	public static void close(AutoCloseable... strem) {
		for (AutoCloseable closeable : strem) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	private DBUtils() {}
}
