package br.usjt.caixaeletronico.control;

public class ContaCtrl {

	public int transferencia(double valor, int agDestino, int acDestino) {
		return Utils.objConta.transferencia(valor, agDestino, acDestino);
	}
	
	public int Saque(double valor){
		return Utils.objConta.saque(valor);
	}
}
