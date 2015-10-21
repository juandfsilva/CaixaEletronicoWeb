package br.usjt.caixaeletronico.control;

public class ContaCtrl {

	public ContaCtrl() {
		
	}
	
	public int transferencia(double valor, int agDestino, int acDestino){
		return Utils.objConta.transferencia(valor, agDestino, acDestino);
	}

}
