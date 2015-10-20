package br.usjt.caixaeletronico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.usjt.caixaeletronico.control.Utils;
import br.usjt.caixaeletronico.view.Mensagem;

public class ContaDAO {
	ResultSet rs;
	String SQL;
	Statement stm;

	public double getSaldo(int agencia, int conta) {
		try {
			double saldot = 0;
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select con_saldo from sis_bancario.conta where con_conta=" + conta + " AND con_agencia=" + agencia
					+ ";";
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

	public void setSaldo(double valor, int agencia, int conta) {
		try {
			SQL = "update sis_bancario.conta" + " set con_saldo=(?)" + " where con_agencia = (?) and con_conta = (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDouble(1, valor);
			preparedStmt.setInt(2, agencia);
			preparedStmt.setInt(3, conta);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String transferencia(double valor, int agDestino, int acDestino, ResourceBundle resourceBundle) {
		// TODO Mexer nessa bagaça logo!!!
		double saldo = Utils.objConta.getSaldo();
		if (verificaCadastro(agDestino, acDestino)) {
			if (saldo >= valor) {
				try {
					// Conta de saida
					Utils.objConta.setSaldo((saldo - valor));

					// Conta de transf
					Conta accTransf = new Conta(0, acDestino, agDestino, 0, 0, null);
					double saldoDest = accTransf.getSaldo() + valor;
					accTransf.setSaldo(saldoDest);
					return resourceBundle.getString("Transferencia.sucesso");
				} catch (Exception e) {
					e.printStackTrace();
					return resourceBundle.getString("Transferencia.erro");
				}

			} else {
				return resourceBundle.getString("Transferencia.semSaldo");
			}
		} else {
			return resourceBundle.getString("Transferencia.erro");
		}
	}

	public boolean verificaCadastro(int agencia, int conta) {
		int verfic = 0;
		try {
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta where con_conta=" + conta + " AND con_agencia=" + agencia + ";";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				verfic = rs.getInt("con_conta");
			}
			if (verfic > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//TODO VERIFICA BANCO :*
}
