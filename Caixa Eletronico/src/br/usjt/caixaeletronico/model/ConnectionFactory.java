package br.usjt.caixaeletronico.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionFactory {
	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:3306/";// 8080 na maquina da
														// KPIT, 3306 em casa
	static String dbName = "sis_bancario";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";

	static String acesso = "";
	private static Scanner read;

	public static void openFactory() {
		try {
			Class.forName(driver).newInstance();
			// conn = DriverManager.getConnection(url + dbName, userName,
			// password);
			String[] dados = ler();
			conn = DriverManager.getConnection(dados[0], dados[1], dados[2]);
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

	public static String[] ler() throws IOException {
		String[] ler = { "", "", "" };
		FileInputStream stream = new FileInputStream("banco.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		for(int i=0;i<3;i++){
			ler[i] = linha.substring(0, linha.indexOf('|'));
			linha = br.readLine();
		}
		return ler;
	}

}
