package br.usjt.caixaeletronico.model;

import java.util.ResourceBundle;

public class Conta {
	int conta, agencia, cli_id, cod_acesso;
	double saldo;
	String banco;
	ContaDAO contaDAO = new ContaDAO();
	
	public Conta() {
		cli_id = 0;
		conta = 0000000;
		agencia = 000000;
		cod_acesso = 000;
		saldo = 0.00;
		banco = "";
	}
	
	public Conta(int cli_id, int conta, int agencia, int cod_acesso, double saldo, String banco) {
		setConta(conta);
		setAgencia(agencia);
		setCliCod(cli_id);
		setBanco(banco);
		setAcesso(cod_acesso);
		setSaldo(getSaldo());
	}
		


	public int getConta() {
		return conta;
	}
	
	public String getBanco() {
		return banco;
	}

	public double getSaldo() {
		ContaDAO saldoDAO = new ContaDAO();
		double saldot = saldoDAO.getSaldo(getAgencia(), getConta());
		return saldot;
	}

	public int getAgencia() {
		return agencia;
	}
	
	public int getCodAcesso() {
		return cod_acesso;
	}
	
	public int getCliCod() {
		return cli_id;
	}
	
	public void setAcesso(int cod_acesso) {
		this.cod_acesso = cod_acesso;
	}
	
	public void setCliCod(int cli_id) {
		this.cli_id = cli_id;
	}
	
	private void setBanco(String banco) {
		this.banco = banco;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public void setSaldo(double saldo) {
		try{
		contaDAO.setSaldo(saldo, getAgencia(), getConta());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public String transferencia(double valor, int agDestino, int acDestino, ResourceBundle resourceBundle){
		return contaDAO.transferencia(valor, agDestino, acDestino, resourceBundle);
	}
	
}
