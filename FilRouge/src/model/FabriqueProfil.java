package model;

public class FabriqueProfil {
	 public Profil getProfil( ProfilUtilisateur profilUtilisateur,String nom, String prenom, String mdp)
	 
		{
			 
		 Profil profil =null ;
		 switch (profilUtilisateur)
		 {
		 case UTILISATEUR:
			 profil=new Utilisateur(nom,prenom,mdp);
			 break;
			 
		 default :
			 profil =new Admin(nom,prenom,mdp);
			 break;
			 
		 }
		return profil;
			
		}
}
