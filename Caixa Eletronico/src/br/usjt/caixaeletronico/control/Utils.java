package br.usjt.caixaeletronico.control;

import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.generic.D2F;

import br.usjt.caixaeletronico.model.Conta;
import br.usjt.caixaeletronico.model.Data;

public class Utils {
	public static Conta objConta = new Conta();
	public static ResourceBundle resource = null;
	public static Data data = new Data(); 
	
	public static void setBundle(ResourceBundle rb){
		resource = rb;
	}
	
	public static ResourceBundle getBundle(){
		return resource;
	}
}
