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

	public void putMov(Movimentacao mov, int acDest, int agDest, int docDebito, int codCli, int dia) {
		try {
			SQL = "INSERT INTO sis_bancario.movimentacao"
					+ "(mov_data, mov_conta, mov_agencia, mov_tipo, mov_valor, mov_accTo, mov_agTo, mov_docto, mov_doctoCli, mov_diaVenct)" + "VALUES (?,?,?,?,?,?,?,?,?,?)";
			// setting prepared statement
			PreparedStatement preparedStmt = (PreparedStatement) ConnectionFactory.conn.prepareStatement(SQL);
			preparedStmt.setDate(1, mov.getData());
			preparedStmt.setInt(2, mov.conta.getConta());
			preparedStmt.setInt(3, mov.conta.getAgencia());
			preparedStmt.setInt(4, mov.getTipo());
			preparedStmt.setDouble(5, mov.getValor());
			preparedStmt.setInt(6, acDest);
			preparedStmt.setInt(7, agDest);
			preparedStmt.setInt(8, docDebito);
			preparedStmt.setInt(9, codCli);
			preparedStmt.setInt(10, dia);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getMovString(Conta conta) {
		try {
			String linha = "";
			stm = (Statement) ConnectionFactory.conn.createStatement();
			SQL = "select * from sis_bancario.movimentacao where mov_conta=" + conta.getConta() + " AND mov_agencia="
					+ conta.getAgencia() + ";";
			rs = stm.executeQuery(SQL);
			while (rs.next()) {
				linha += String.valueOf(rs.getDate("mov_data"));
				linha += "  ";
				linha += String.valueOf(rs.getInt("mov_conta"));
				linha += "  ";
				linha += String.valueOf(rs.getInt("mov_agencia"));
				linha += "  ";
				linha += rs.getDouble("mov_valor");
				linha += "  ";
				if(rs.getInt("mov_tipo") == 1) {
					linha +="Transferencia";
					linha += "  ";
					linha += String.valueOf(rs.getInt("mov_accTo"));
					linha += "  ";
					linha += String.valueOf(rs.getInt("mov_agTo"));
				}else if(rs.getInt("mov_tipo") == 2){
					linha +="Debito Automatico";
					linha += "  ";
					linha += String.valueOf(rs.getInt("mov_docto"));
					linha += "  ";
					linha += String.valueOf(rs.getInt("mov_doctoCli"));
					linha += "  ";
					linha += String.valueOf(rs.getInt("mov_diaVenct"));
					linha += "  ";
				}else if(rs.getInt("mov_tipo") == 3){
					linha +="Saque";
				}
				linha += "\n";
			}
			return linha;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
