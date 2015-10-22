package br.usjt.caixaeletronico.control;

public class AcessoCtrl {

	public boolean verifica() {
		String co = String.valueOf(Utils.objConta.getCodAcesso());
		String co = "123";
		String cod[] = new String[3];
		for (int i = 0; i < 3; i++) {
			cod[i] = co.substring(i, (i + 1));
		}
		if(cod[0].equals(Utils.codAcesso.substring(0,1)) || cod[0].equals(Utils.codAcesso.substring(1,2)) ){
			if(cod[1].equals(Utils.codAcesso.substring(2,3)) ||cod[1].equals(Utils.codAcesso.substring(3,4)) ){
				if(cod[2].equals(Utils.codAcesso.substring(4,5)) ||cod[2].equals(Utils.codAcesso.substring(5,6)) ){
					return true;
				}
			}
		}
		return false;
	}

}
