package br.usjt.caixaeletronico.control;

import java.util.ResourceBundle;

import br.usjt.caixaeletronico.model.Conta;

public class Utils {
	public static Conta objConta;
	public static ResourceBundle resource;
	
	
	public static void setBundle(ResourceBundle rb){
		resource = rb;
	}
	
	public static ResourceBundle getBundle(){
		return resource;
	}
}
