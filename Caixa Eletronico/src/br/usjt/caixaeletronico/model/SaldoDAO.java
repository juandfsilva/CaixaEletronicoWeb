package br.usjt.caixaeletronico.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.usjt.caixaeletronico.control.Utils;

public class SaldoDAO {
	ResultSet rs;
	String SQL;
	Statement stm;

	public SaldoDAO() {
		try {
			stm = (Statement) ConnectionFactory.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getSaldo() {
		try {
			ConnectionFactory.openFactory();
			SQL = "select * from sis_bancario.conta where con_conta like \'" + Utils.objConta.getConta()
					+ "\'and con_agencia like \'" + Utils.objConta.getAgencia() + "\';";
			rs = stm.executeQuery(SQL);
			ConnectionFactory.closeFactory();
			return rs.getInt("con_saldo");
		} catch (SQLException e) {
			e.printStackTrace();
			return -123456;
		}

	}

	public void setSaldo(double saldo) {
		try {
			ConnectionFactory.openFactory();
			SQL = "insert into sis_bancario.conta (con_saldo)"
					+ " values (?) where con_agencia like (?) and con_conta like (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDouble(1, saldo);
			preparedStmt.setInt(2, Utils.objConta.getAgencia());
			preparedStmt.setInt(3, Utils.objConta.getConta());
			preparedStmt.execute();
			ConnectionFactory.closeFactory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
