package control;

import model.Admin;
import model.FabriqueProfil;
import model.Profil;
import model.ProfilUtilisateur;
import model.Utilisateur;
import model.BDProfil ;




public class ControlCreerProfil {
	private FabriqueProfil fabriqueProfil ;
	private ControlProfil controlProfil=new ControlProfil();
	private BDProfil bdProfil =BDProfil.getInstance();
	
	public ControlCreerProfil() {
		this.fabriqueProfil = new FabriqueProfil();
		
	}
	public Profil creerProfil(ProfilUtilisateur profilUtilisateur ,String prenom ,String nom ,String mdp)
	{
		Profil profil  = this.fabriqueProfil.getProfil(profilUtilisateur, prenom, nom, mdp);
		controlProfil.addProfil(profil);
		
		return profil ;
	
	}
	
	/**
	 * 
	 * @param mdp
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
	public String visualiserBDUtilisateur() {
		String retour = this.bdProfil.toString();
		
		return retour;
	}
}
