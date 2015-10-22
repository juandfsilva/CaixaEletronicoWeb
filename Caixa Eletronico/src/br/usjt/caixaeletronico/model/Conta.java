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
		String bancot = contaDAO.getBanco(getAgencia(), getConta());
		return bancot;
	}

	public double getSaldo() {
		double saldot = contaDAO.getSaldo(getAgencia(), getConta());
		return saldot;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getCodAcesso() {
		int acesso = contaDAO.getCodAcesso(getAgencia(), getConta());
		return acesso;
	}

	public int getCliCod() {
		return cli_id;
	}

	public void setAcesso(int cod_acesso) {
		try {
			contaDAO.setCodAcesso(cod_acesso, getAgencia(), getConta());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCliCod(int cli_id) {
		this.cli_id = cli_id;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setSaldo(double saldo) {
		try {
			contaDAO.setSaldo(saldo, getAgencia(), getConta());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int transferencia(double valor, int agDestino, int acDestino) {
		return contaDAO.transferencia(valor, agDestino, acDestino);
	}

	public boolean verificaBanco(String bancoDest) {
		return getBanco().equals(bancoDest);
	}

	public boolean primeiroAcesso() {
		return contaDAO.primeiroAcesso(getAgencia(), getConta());
	}
}
