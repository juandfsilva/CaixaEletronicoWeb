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

	public double getSaldo() {
		try {
			double saldot = 0;
			ConnectionFactory.openFactory();
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select con_saldo from sis_bancario.conta where con_conta="+Utils.objConta.getConta()+
					" AND con_agencia="+Utils.objConta.getAgencia()+";";
			rs = stm.executeQuery(SQL);
			while ( rs.next() ) {
				saldot = rs.getDouble("con_saldo");
            }
			ConnectionFactory.closeFactory();
			return saldot;
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
