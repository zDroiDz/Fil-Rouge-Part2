package control;

import model.Admin;
import model.FabriqueProfil;
import model.Profil;
import model.ProfilUtilisateur;
import model.Utilisateur;
import model.BDProfil ;




public class ControlCreerProfil {
	private FabriqueProfil fabriqueProfil ;
	private BDProfil bdProfil =BDProfil.getInstance();
	public ControlCreerProfil() {
		this.fabriqueProfil = new FabriqueProfil();
		
	}
	public Profil creerProfil(ProfilUtilisateur profilUtilisateur ,String nom ,String prenom ,String mdp)
	{
		Profil profil = null ;
		switch (profilUtilisateur)
		{
		case UTILISATEUR :
			profil = this.fabriqueProfil.getProfil(ProfilUtilisateur.UTILISATEUR, nom, prenom, mdp);
			bdProfil.ajouterUtilisateur(profil);
		    break;
		case ADMIN	:
			profil = this.fabriqueProfil.getProfil(ProfilUtilisateur.ADMIN, nom, prenom, mdp);
			profil.definirAdmin();
			bdProfil.ajouterUtilisateur(profil);
		    break;
		}
		
		return profil ;
	
	}
	public String visualiserBDUtilisateur() {
		String retour = this.bdProfil.toString();
		
		return retour;
	}
}
