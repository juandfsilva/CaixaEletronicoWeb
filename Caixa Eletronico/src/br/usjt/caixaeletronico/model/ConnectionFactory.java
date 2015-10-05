package br.usjt.caixaeletronico.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ConnectionFactory {
	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:8080/";//8080 na maquina da KPIT, 3306 em casa
	static String dbName = "sis_bancario";                                                    
	static String driver = "com.mysql.jdbc.Driver";                                           
	static String userName = "root";                                                          
	static String password = "root";                                                          

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
