package control;

import model.Admin;
import model.BDProfil;
import model.FabriqueProfil;
import model.ProfilUtilisateur;
import model.Utilisateur;




public class ControlCreerProfil {
	private FabriqueProfil fabriqueProfil ;
	private BDProfil bdProfil =BDProfil.getInstance();
	public ControlCreerProfil() {
		this.fabriqueProfil = new FabriqueProfil();
		
	}
	public void creerProfilGerant(ProfilUtilisateur profilUtilisateur ,String nom ,String prenom ,String mdp)
	{
		switch (profilUtilisateur)
		{
		case UTILISATEUR :
			Utilisateur utilisateur =(Utilisateur)this.fabriqueProfil.getProfil(ProfilUtilisateur.UTILISATEUR, nom, prenom, mdp);
			bdProfil.ajouterUtilisateur(utilisateur);
		    //bdProfil.ajouterProfil(client);
		    break;
		case ADMIN	:
			Admin admin =(Admin)this.fabriqueProfil.getProfil(ProfilUtilisateur.ADMIN, nom, prenom, mdp);
			admin.definirGerant();
			bdProfil.ajouterUtilisateur(admin);
			//bdProfil.ajouterProfil(client);
		    break;
		}
	
	}
	public String visualiserBDUtilisateur() {
		String retour = this.bdProfil.toString();
		
		return retour;
	}
}
