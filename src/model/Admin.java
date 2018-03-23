package model;

public class Admin extends Profil {


	
	public Admin(String nom, String prenom ,String mdp) {
		super(nom, prenom, mdp);
	}
	
	public boolean isGerant(){
		return getAdmin();
	}
	public void definirGerant(){
		setAdmin();
	}
}
