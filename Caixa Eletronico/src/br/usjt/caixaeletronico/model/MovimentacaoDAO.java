package br.usjt.caixaeletronico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MovimentacaoDAO {
	ResultSet rs;
	String SQL;
	Statement stm;
	String[] retorno;

	public void putMov(Movimentacao mov) {
		try {
			SQL = "INSERT INTO sis_bancario.movimentacao"
					+ "(mov_data, mov_conta, mov_agencia, mov_tipo, mov_valor) VALUES" + "(?,?,?,?,?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDate(1, mov.getData());
			preparedStmt.setInt(2, mov.conta.getConta());
			preparedStmt.setInt(3, mov.conta.getAgencia());
			preparedStmt.setInt(4, mov.getTipo());
			preparedStmt.setDouble(5, mov.getValor());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getMov(Conta conta) {
		try {
			ArrayList<String> lista = new ArrayList<String>();
			String linha = "";
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.movimentacao where mov_conta=" + conta.getConta() + " AND mov_agencia=" + conta.getAgencia()
					+ ";";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				linha = String.valueOf(rs.getDate("mov_data"));
				linha = "  ";
				linha += rs.getInt("mov_conta");
				linha = "  ";
				linha += rs.getInt("mov_agencia");
				linha = "  ";
				linha += rs.getInt("mov_tipo");
				linha = "  ";
				linha += rs.getDouble("mov_valor");
				lista.add(linha);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
}
