package ca.csf.dfc.main.console;

public class MainConsole {

	public static void main(String[] args) {
		Telephone iPhone = new Telephone("555-555-5555","iPhoneXR");
		Utilisateur gaston = new Utilisateur("Gaston", "Piche", 58, true, iPhone);
		
		System.out.println(gaston);
	}

}
