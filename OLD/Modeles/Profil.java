package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Profil {
	
	private String identifiant;
	private String mdp;
	private String nom;
	private String prenom;
	private boolean admin;
	private List<String> historique;
	private boolean isHistorique;
	
	
	public Profil(String prenom,String nom,String mdp)
	{
		this.prenom=prenom;
		this.nom=nom;
		this.mdp=mdp;
		this.identifiant=prenom+"."+nom;
		this.historique=new ArrayList<>();
		this.admin=false;
		this.isHistorique=false;
	}
	
	public void definirAdmin()
	{
		this.admin=true;
	}
	

}
