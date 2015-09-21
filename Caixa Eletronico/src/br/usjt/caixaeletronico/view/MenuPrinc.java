package br.usjt.caixaeletronico.view;

public class MenuPrinc extends MenuTemplate {
	private static String[] buttonsText = {Messages.getString("MenuPrinc.0"), Messages.getString("MenuPrinc.1"),  //$NON-NLS-1$ //$NON-NLS-2$
												Messages.getString("MenuPrinc.2"),Messages.getString("MenuPrinc.3"),  //$NON-NLS-1$ //$NON-NLS-2$
													Messages.getString("MenuPrinc.4"), Messages.getString("MenuPrinc.5")}; //$NON-NLS-1$ //$NON-NLS-2$
	
	public MenuPrinc()
	{
		super(Messages.getString("MenuPrinc.6"), Messages.getString("MenuPrinc.7"),buttonsText); //$NON-NLS-1$ //$NON-NLS-2$
	}
	

}
