package br.usjt.caixaeletronico.model;

public class Conta {
	int conta, agencia;
	double saldo;
	
	public Conta() {
		conta = 0000000;
		agencia = 000000;
		saldo = 0.00;
	}
	
	public Conta(int conta, int agencia, double saldo) {
		setConta(conta);
		setAgencia(agencia);
		setSaldo(saldo);
	}
		
	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
}
