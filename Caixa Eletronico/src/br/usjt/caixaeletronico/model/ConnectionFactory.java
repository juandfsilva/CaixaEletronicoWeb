package br.usjt.caixaeletronico.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ConnectionFactory {
	static Connection conn = null;
	public ConnectionFactory() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "sis_bancario";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Conectado!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeFactory() {
		try {
			conn.close();
			System.out.println("Fechado!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
