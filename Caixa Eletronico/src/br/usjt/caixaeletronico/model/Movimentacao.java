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
	
	public void insert(int acDest, int agDest, int doctoDebt, int codCli, int dia){
		movDAO.putMov(this, acDest, agDest, doctoDebt, codCli, dia);
	}
	
	
	
	
}
