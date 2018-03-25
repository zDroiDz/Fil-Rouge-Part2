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
	public Profil creerProfil(ProfilUtilisateur profilUtilisateur ,String nom ,String prenom ,String mdp)
	{
		Profil profil  = this.fabriqueProfil.getProfil(profilUtilisateur, nom, prenom, mdp);
		controlProfil.addProfil(profil);
		
		return profil ;
	
	}
	public String visualiserBDUtilisateur() {
		String retour = this.bdProfil.toString();
		
		return retour;
	}
}
