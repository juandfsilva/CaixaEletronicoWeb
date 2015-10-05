package br.usjt.caixaeletronico.control;

import java.util.ResourceBundle;

import br.usjt.caixaeletronico.model.Conta;

public class Utils {
	public static Conta objConta = new Conta();
	public static ResourceBundle resource = null;
	
	
	public static void setBundle(ResourceBundle rb){
		resource = rb;
	}
	
	public static ResourceBundle getBundle(){
		return resource;
	}
}
