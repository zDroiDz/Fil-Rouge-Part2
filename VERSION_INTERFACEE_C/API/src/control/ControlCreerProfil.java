package control;

import model.Admin;
import model.FabriqueProfil;
import model.Profil;
import model.ProfilUtilisateur;
import model.Utilisateur;
import model.BDProfil ;




// TODO: Auto-generated Javadoc
/**
 * The Class ControlCreerProfil.
 */
public class ControlCreerProfil {
	
	/** The fabrique profil. */
	private FabriqueProfil fabriqueProfil ;
	
	/** The control profil. */
	private ControlProfil controlProfil=new ControlProfil();
	
	/** The bd profil. */
	private BDProfil bdProfil =BDProfil.getInstance();
	
	/**
	 * Instantiates a new control creer profil.
	 */
	public ControlCreerProfil() {
		this.fabriqueProfil = new FabriqueProfil();
		
	}
	
	/**
	 * Creer profil.
	 *
	 * @param profilUtilisateur the profil utilisateur
	 * @param prenom the prenom
	 * @param nom the nom
	 * @param mdp the mdp
	 * @return the profil
	 */
	public Profil creerProfil(ProfilUtilisateur profilUtilisateur ,String prenom ,String nom ,String mdp)
	{
		Profil profil  = this.fabriqueProfil.getProfil(profilUtilisateur, prenom, nom, mdp);
		controlProfil.addProfil(profil);
		
		return profil ;
	
	}
	
	/**
	 * Verification creation.
	 *
	 * @param mdp the mdp
	 * @return true if creation is possible
	 */
	public boolean verificationCreation(String mdp) {
		
		for(Profil p : bdProfil.getProfils()) {
			if(p.getMDP().equals(mdp)) {
				return false ;
			}
		}
		
		return true ;
	}
	
	/**
	 * Visualiser BD utilisateur.
	 *
	 * @return the string
	 */
	public String visualiserBDUtilisateur() {
		String retour = this.bdProfil.toString();
		
		return retour;
	}
}
