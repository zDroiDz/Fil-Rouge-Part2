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
	
	
	public void setAdmin()
	{
		this.admin=true;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
	
	public String getIdentifiant()
	{
		return this.identifiant;
	}
	
	public void definirAdmin(){
		this.admin = true ;
	}
	
	public String getMDP()
	{
		return this.mdp;
	}

	@Override
	public String toString() {
		return "Profil [identifiant=" + identifiant + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom
				+ ", admin=" + admin + ", historique=" + historique + ", isHistorique=" + isHistorique + "]";
	}
	
	

}
