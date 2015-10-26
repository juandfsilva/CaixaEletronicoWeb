package br.usjt.caixaeletronico.control;

public class CadAcessCtrl {

	public boolean cadastra(int cod_acesso) {
		try {
			Utils.objConta.setAcesso(cod_acesso);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
