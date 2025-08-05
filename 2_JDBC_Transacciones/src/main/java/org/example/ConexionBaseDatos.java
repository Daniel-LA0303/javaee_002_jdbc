package org.example;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionBaseDatos {

	// con pool de conexiones
	private static String url = "jdbc:mysql://localhost:3306/javaee_002_db_curso";
	private static String username = "root";
	private static String password = "1234";
	private static BasicDataSource pool;

	// Aplicando el patron Singleton
	public static BasicDataSource getConexion() throws SQLException {
		if (pool == null) {
			pool = new BasicDataSource();
			pool.setUrl(url);
			pool.setUsername(username);
			pool.setPassword(password);
			pool.setInitialSize(3); // 3 conexiones iniciales
			pool.setMinIdle(3); // 3 conexiones minimas
			pool.setMaxIdle(10); // 10 conexiones maximas
			pool.setMaxTotal(10); // 10 conexiones maximas

		}
		return pool;
	}

	public static Connection getConnection() throws SQLException {
		return getConexion().getConnection();
	}

	// sin pool de conexiones
	/*
	 * private static String url = "jdbc:mysql://localhost:3306/jdbc_db_10"; private
	 * static String username = "root"; private static String password = "1234";
	 * private static Connection conn = null;
	 * 
	 * 
	 * //Aplicando el patron Singleton public static Connection getConexion() throws
	 * SQLException { if(conn == null){ conn = DriverManager.getConnection(url,
	 * username, password); } return conn; }
	 */
}
