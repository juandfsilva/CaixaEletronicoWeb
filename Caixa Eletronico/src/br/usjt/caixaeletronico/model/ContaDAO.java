package br.usjt.caixaeletronico.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.usjt.caixaeletronico.control.Utils;

public class ContaDAO {
	ResultSet rs;
	String SQL;
	Statement stm;

	public double getSaldo() {
		try {
			double saldot = 0;
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select con_saldo from sis_bancario.conta where con_conta=" + Utils.objConta.getConta()
					+ " AND con_agencia=" + Utils.objConta.getAgencia() + ";";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				saldot = rs.getDouble("con_saldo");
			}
			return saldot;
		} catch (SQLException e) {
			e.printStackTrace();
			return -123456;
		}

	}

	public void setSaldo(double valor) {
		try {
			SQL = "insert into sis_bancario.conta (con_saldo)"
					+ " values (?) where con_agencia like (?) and con_conta like (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDouble(1, valor);
			preparedStmt.setInt(2, Utils.objConta.getAgencia());
			preparedStmt.setInt(3, Utils.objConta.getConta());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void transferencia(double valor, int agDestino, int acDestino){
		//TODO Mexer nessa bagaça logo!!!
		double saldo = getSaldo();
		if(saldo > valor){
			try {
				//Conta de saida
				setSaldo(saldo - valor);
				
				//Conta de transf
				Conta accTransf = new Conta(0, acDestino, agDestino, 0, 0, null);
				accTransf.setSaldo(accTransf.getSaldo() + valor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente para esta transação");
		}
	}
}
