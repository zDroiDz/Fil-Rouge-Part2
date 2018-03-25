package model;

public class Admin extends Profil {


	
	public Admin(String prenom, String nom ,String mdp) {
		super(prenom, nom, mdp);
		this.definirAdmin();
	}
	

	public void definirAdmin(){
		setAdmin();
	}
}
