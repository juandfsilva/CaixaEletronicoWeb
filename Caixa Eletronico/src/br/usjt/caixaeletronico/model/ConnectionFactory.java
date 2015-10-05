package br.usjt.caixaeletronico.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ConnectionFactory {
	static Connection conn = null;
	static String url;
	static String dbName;
	static String driver;
	static String userName;
	static String password;

	public ConnectionFactory() {
		url = "jdbc:mysql://localhost:3306/";
		dbName = "sis_bancario";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		password = "root";
	}

	public static void openFactory() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Conectado!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeFactory() {
		try {
			conn.close();
			System.out.println("Fechado!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
