package model;

// TODO: Auto-generated Javadoc
/**
 * The Class FabriqueProfil.
 */
public class FabriqueProfil {
	 
 	/**
 	 * Gets the profil.
 	 *
 	 * @param profilUtilisateur the profil utilisateur
 	 * @param prenom the prenom
 	 * @param nom the nom
 	 * @param mdp the mdp
 	 * @return the profil
 	 */
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
