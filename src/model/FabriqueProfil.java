package model;

public class FabriqueProfil {
	 public Profil getProfil( ProfilUtilisateur profilUtilisateur,String prenom, String nom, String mdp)
	 
		{
			 
		 Profil profil =null ;
		 switch (profilUtilisateur)
		 {
		 case UTILISATEUR:
			 profil=new Utilisateur(prenom,nom,mdp);
			 break;
			 
		 default :
			 profil =new Admin(prenom,nom,mdp);
			 break;
			 
		 }
		return profil;
			
		}
}
