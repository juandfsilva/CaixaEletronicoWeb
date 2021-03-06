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
	Movimentacao mov;

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

	public String getBanco(int agencia, int conta) {
		try {
			String banco = "";
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta where con_conta=" + conta + " AND con_agencia=" + agencia + ";";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				banco = rs.getString("con_banco");
			}
			return banco;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	public int getCodAcesso(int agencia, int conta, String banco) {
		try {
			int acesso = 0;
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta" + " where con_conta=" + conta + " AND con_agencia=" + agencia
					+ " AND con_banco='" + banco + "';";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				acesso = rs.getInt("con_codAcesso");
			}
			System.out.println(acesso);
			return acesso;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void setSaldo(double valor, int agencia, int conta, String banco) {
		try {
			SQL = "update sis_bancario.conta" + " set con_saldo=(?)"
					+ " where con_agencia = (?) and con_conta = (?) and con_banco = (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDouble(1, valor);
			preparedStmt.setInt(2, agencia);
			preparedStmt.setInt(3, conta);
			preparedStmt.setString(4, banco);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setBanco(int agencia, int conta, String banco) {
		try {
			SQL = "update sis_bancario.conta" + " set con_banco=(?)" + " where con_agencia = (?) and con_conta = (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setString(1, banco);
			preparedStmt.setInt(2, agencia);
			preparedStmt.setInt(3, conta);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setCodAcesso(int agencia, int conta, int cod, String banco) {
		try {
			SQL = "update sis_bancario.conta" + " set con_codAcesso=(?)" + " where con_agencia = (?) and"
					+ " con_conta = (?) and" + " con_banco = (?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setInt(1, cod);
			preparedStmt.setInt(2, agencia);
			preparedStmt.setInt(3, conta);
			preparedStmt.setString(4, banco);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int transferencia(double valor, int agDestino, int acDestino) {
		Conta accTransf = new Conta(0, acDestino, agDestino, 0, 0, null);
		double saldo = Utils.objConta.getSaldo();
		String bancoDest = Utils.objConta.getBanco(true);
		if (comparaBanco(Utils.objConta.getAgencia(), Utils.objConta.getConta(), bancoDest)) {
			if (verificaCadastro(agDestino, acDestino, bancoDest)) {
				if (saldo >= valor) {
					try {
						// Conta de saida
						Utils.objConta.setSaldo((saldo - valor));

						// Conta de transf
						double saldoDest = accTransf.getSaldo() + valor;
						accTransf.setSaldo(saldoDest);
						// Grava Mov
						mov = new Movimentacao(Utils.objConta, 1, (valor * (-1)));
						mov.insert(accTransf.getConta(), accTransf.getAgencia(), 0, 0, 0);
						mov = new Movimentacao(accTransf, 1, valor);
						mov.insert(accTransf.getConta(), accTransf.getAgencia(), 0,0,0);
						return 1;
					} catch (Exception e) {
						e.printStackTrace();
						return -1;
					}

				} else {
					return 0; // S saldo
				}
			} else {
				return -1; // Conta Inexistente
			}
		} else {
			return -1; // Banco diferente
		}
	}

	public int Saque(double valor) {
		double saldo = Utils.objConta.getSaldo();
		if (saldo >= valor) {
			try {
				// Conta de saida
				Utils.objConta.setSaldo((saldo - valor));
				// Grava Mov
				mov = new Movimentacao(Utils.objConta, 3, (valor * (-1)));
				mov.insert(0, 0, 0,0,0);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}

		} else {
			return 0; // S saldo
		}
	}

	public int DebitoAutom(int CodOperadora, int codCli, int dia) {
		try {
			// Grava Mov
			mov = new Movimentacao(Utils.objConta, 2,0);
			mov.insert(0, 0, CodOperadora, codCli, dia);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public boolean verificaCadastro(int agencia, int conta, String banco) {
		int verfic = 0;
		try {
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta" + " where con_conta=" + conta + " AND con_agencia=" + agencia
					+ " AND con_banco= '" + banco + "';";
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

	public boolean primeiroAcesso(int agencia, int conta, String banco) {
		int verfic = 0;
		try {
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta where con_conta=" + conta + " AND con_agencia=" + agencia
					+ " AND con_banco='" + banco + "';";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				verfic = rs.getInt("con_codAcesso");
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

	public boolean comparaBanco(int agencia, int conta, String bancoDest) {
		return getBanco(agencia, conta).equals(bancoDest);
	}

	public void bloqueia(int agencia, int conta, String banco, int bloqueia) {
		try {
			SQL = "update sis_bancario.conta set con_bloqueio=(?), con_codAcesso=(?) where con_agencia = (?) and con_conta = (?) and con_banco = (?)";
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setInt(1, bloqueia);
			preparedStmt.setInt(2, 0);
			preparedStmt.setInt(3, agencia);
			preparedStmt.setInt(4, conta);
			preparedStmt.setString(5, banco);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int bloqueada(int agencia, int conta, String banco) {
		int verifica = -1;
		try {
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.conta where con_conta=" + conta + " AND con_agencia=" + agencia
					+ " AND con_banco='" + banco + "';";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				verifica = rs.getInt("con_bloqueio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verifica;
	}
}
