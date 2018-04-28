package model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Profil.
 */
public abstract class Profil {
	
	/** The identifiant. */
	private String identifiant;
	
	/** The mdp. */
	private String mdp;
	
	/** The nom. */
	private String nom;
	
	/** The prenom. */
	private String prenom;
	
	/** The admin. */
	private boolean admin;
	
	/** The historique. */
	private List<String> historique;
	
	/** The is historique. */
	private boolean isHistorique;
	
	
	/**
	 * Instantiates a new profil.
	 *
	 * @param prenom the prenom
	 * @param nom the nom
	 * @param mdp the mdp
	 */
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
	
	
	/**
	 * Sets the admin.
	 */
	public void setAdmin()
	{
		this.admin=true;
	}
	
	/**
	 * Checks if is admin.
	 *
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return this.admin;
	}
	
	/**
	 * Gets the identifiant.
	 *
	 * @return the identifiant
	 */
	public String getIdentifiant()
	{
		return this.identifiant;
	}
	
	/**
	 * Definir admin.
	 */
	public void definirAdmin(){
		this.admin = true ;
	}
	
	/**
	 * Gets the mdp.
	 *
	 * @return the mdp
	 */
	public String getMDP()
	{
		return this.mdp;
	}
	
	/**
	 * Sets the historique.
	 */
	public void setHistorique(){
		this.isHistorique = true ;
	}

	/**
	 * Sets the no historique.
	 */
	public void setNoHistorique() {
		this.isHistorique = false ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profil [identifiant=" + identifiant + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom
				+ ", admin=" + admin + ", historique=" + historique + ", isHistorique=" + isHistorique + "]";
	}


	/**
	 * Checks if is historique.
	 *
	 * @return true, if is historique
	 */
	public boolean isHistorique() {
		return this.isHistorique;
	}
	
	

}
