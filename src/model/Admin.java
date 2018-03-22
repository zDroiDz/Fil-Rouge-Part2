package model;

public class Admin extends Profil {

private boolean adming=false ;
	
	public Admin(String nom, String prenom ,String mdp) {
		super(nom, prenom, mdp);
	}
	
	public boolean isGerant(){
		return this.adming;
	}
	public void definirGerant(){
		this.adming = true;
	}
}
