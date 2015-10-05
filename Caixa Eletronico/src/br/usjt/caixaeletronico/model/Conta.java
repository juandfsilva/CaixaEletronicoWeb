package br.usjt.caixaeletronico.model;

public class Conta {
	int conta, agencia, cli_cod;
	double saldo;
	
	public Conta() {
		conta = 0000000;
		agencia = 000000;
		saldo = 0.00;
		cli_cod = 0;
	}
	
	public Conta(int codcliente, int conta, int agencia, double saldo) {
		setConta(conta);
		setAgencia(agencia);
		setSaldo(saldo);
		setCliCod(codcliente);
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
	
	public int getCliCod() {
		return cli_cod;
	}
	
	public void setCliCod(int cli_cod) {
		this.cli_cod = cli_cod;
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
