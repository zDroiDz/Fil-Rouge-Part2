package model;

public class Admin extends Profil {


	
	public Admin(String nom, String prenom ,String mdp) {
		super(prenom, nom, mdp);
		this.definirAdmin();
	}
	

	public void definirAdmin(){
		setAdmin();
	}
}
