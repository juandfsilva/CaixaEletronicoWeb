package br.usjt.caixaeletronico.model;

import java.sql.Date;
import java.util.ArrayList;

public class Movimentacao {
	
	Date data;
	Conta conta;
	int tipo; //1,2,3(Transf,debAutom,Saque)
	double valor;
	MovimentacaoDAO movDAO = new MovimentacaoDAO();
	
	public Movimentacao(Conta conta, int tipo, double valor) {
		data = getCurrentDate();
		this.conta = conta;
		setTipo(tipo);
		setValor(valor);
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public String[] getMovsToVector(Conta conta){
		ArrayList<String> array = movDAO.getMov(conta);
		String[] valores = new String[array.size()];
		for(int i=0; i<array.size();i++){
			valores[i] = array.get(i);
		}
		return valores;	
	}
	
	public ArrayList<String> getMovs(Conta conta){
		return movDAO.getMov(conta);
	}
	
	public void insert(){
		movDAO.putMov(this);
	}
	
	
	
	
}
