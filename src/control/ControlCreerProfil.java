package control;

import model.Admin;
import model.BDAdministrateur;
import model.BDUtilisateur;
import model.FabriqueProfil;
import model.ProfilUtilisateur;
import model.Utilisateur;




public class ControlCreerProfil {
	private FabriqueProfil fabriqueProfil ;
	private BDUtilisateur bdUtilisateur = BDUtilisateur.getInstance();
	private BDAdministrateur bdAdministrateur = BDAdministrateur.getInstance() ;
	public ControlCreerProfil() {
		this.fabriqueProfil = new FabriqueProfil();
		this.bdUtilisateur = BDUtilisateur.getInstance();
		this.bdAdministrateur = BDAdministrateur.getInstance();
	}
	public void creerProfilGerant(ProfilUtilisateur profilUtilisateur ,String nom ,String prenom ,String mdp)
	{
		switch (profilUtilisateur)
		{
		case UTILISATEUR :
			Utilisateur client =(Utilisateur)this.fabriqueProfil.getProfil(ProfilUtilisateur.UTILISATEUR, nom, prenom, mdp);
		    bdUtilisateur.ajouterUtilisateur(client);
		    //bdProfil.ajouterProfil(client);
		    break;
		case ADMIN	:
			Admin personnel =(Admin)this.fabriqueProfil.getProfil(ProfilUtilisateur.ADMIN, nom, prenom, mdp);
			personnel.definirGerant();
			bdAdministrateur.ajouterPersonnel(personnel);
			//bdProfil.ajouterProfil(client);
		    break;
		}
	
	}
	public String visualiserBDUtilisateur() {
		String retour = this.bdAdministrateur.toString();
		
		retour += "\n"+this.bdUtilisateur.toString();
		return retour;
	}
}
