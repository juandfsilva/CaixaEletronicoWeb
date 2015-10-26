package br.usjt.caixaeletronico.control;

public class AcessoCtrl {

	public boolean verifica(String codAcesso) {
		String co = String.valueOf(Utils.objConta.getCodAcesso());
		// String co = "123";
		char[] cod = co.toCharArray();
		char[] ca = codAcesso.toCharArray();
		return ((cod[0] == ca[0] || cod[0] == ca[1]) && (cod[1] == ca[2] || cod[1] == ca[3]) && (cod[2] == ca[4] || cod[2] == ca[5]));
	}
	
	public void Cadastra(int cod_acesso){
		Utils.objConta.setAcesso(cod_acesso);
	}
	
}
